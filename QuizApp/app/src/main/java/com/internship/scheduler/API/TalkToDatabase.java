package com.internship.scheduler.API;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.internship.scheduler.Activity.Faculty.FacultyHome;
import com.internship.scheduler.Adapter.CalendarAdapter;
import com.internship.scheduler.Entity.CalendarEvent;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


public class TalkToDatabase extends AsyncTask {

    Context context;
    RecyclerView recyclerView;
    CalendarAdapter adapter;
    ProgressDialog progressDialog;
    String message;
    String date;

    public TalkToDatabase(Context context, RecyclerView recyclerView,String message){
        this.context = context;
        this.recyclerView = recyclerView;
        this.message = message;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(message);
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        try{
            String link="https://quiz-scheduler-demo.000webhostapp.com/quizAPI.php";
            date = objects[0].toString();
            List<NameValuePair> parameters = new ArrayList<>();
            parameters.add(new BasicNameValuePair("date",date));
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(link);
            httpPost.setEntity(new UrlEncodedFormEntity(parameters));

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            InputStream is = httpEntity.getContent();

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while((line = reader.readLine()) != null) {
                sb.append(line);
                break;
            }
            return sb.toString();
        } catch(Exception e){
            return (new String("Exception: " + e.getMessage()));
        }
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        progressDialog.dismiss();
        String result = o.toString();
        if(result.contains("Exception"))
            Toast.makeText(context, result, Toast.LENGTH_SHORT).show();

        try {
            JSONObject json = new JSONObject(result);
            JSONArray schedules = json.getJSONArray("schedules");
            List<CalendarEvent> eventItems = new ArrayList<>();
            Date seletedDate = new SimpleDateFormat("yyyy-mm-dd").parse(date);
            for(int i = 0 ; i < schedules.length(); i++){
                JSONObject current = schedules.getJSONObject(i);
                int sid = current.getInt("sid");
                String time= current.getString("time");
                String subject= current.getString("subject");
                String title= current.getString("title");
                String description= current.getString("description");
                int fid = current.getInt("fid");

                CalendarEvent calendarEvent=new CalendarEvent(i,title,subject,description,seletedDate,time,"312,309,315,317",fid,"SVJ Ma'am");
                eventItems.add(calendarEvent);
            }

            adapter=new CalendarAdapter(eventItems, context);
            recyclerView.setAdapter(adapter);
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}