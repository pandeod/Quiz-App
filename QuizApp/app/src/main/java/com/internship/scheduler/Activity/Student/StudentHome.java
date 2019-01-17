package com.internship.scheduler.Activity.Student;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.CalendarView;
import android.widget.TextView;

import com.internship.scheduler.API.TalkToDatabase;
import com.internship.scheduler.Activity.BaseActivity;
import com.internship.scheduler.Adapter.CalendarAdapter;
import com.internship.scheduler.Entity.CalendarEvent;
import com.internship.scheduler.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class StudentHome  extends BaseActivity implements OnDateSelectedListener {

    RecyclerView recyclerView;
    CalendarAdapter adapter;
    List<CalendarEvent> eventItems;
    MaterialCalendarView calendarView;
    TextView todaysDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);
        setActionBar("Scheduled Events");

        todaysDate=findViewById(R.id.date_today);
        calendarView=findViewById(R.id.calendarView);

        calendarView.setOnDateChangedListener(this);
        calendarView.setShowOtherDates(MaterialCalendarView.SHOW_ALL);

        Calendar instance=Calendar.getInstance();
        calendarView.setSelectedDate(instance);

        CalendarDay cd=new CalendarDay(instance);
        todaysDate.setText("You are Viewing : "+cd.getDay()+"-"+cd.getMonth()+1+"-"+cd.getYear());

        eventItems=new ArrayList<>();
        for(int i=1;i<5;i++)
        {
            Date firstDate1 = new Date(2018,07,06);
            CalendarEvent calendarEvent=new CalendarEvent(i,"MP IA"+i,"Mobile Programming","Module 1&2",firstDate1,"3:30 PM to 3:45 PM","312,309,315,317",123,"SVJ Ma'am");
            eventItems.add(calendarEvent);
        }

        recyclerView=findViewById(R.id.faculty_events_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter=new CalendarAdapter(eventItems, getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setFocusable(false);
        ViewCompat.setNestedScrollingEnabled(recyclerView,false);
    }

    public void setActionBar(String heading) {
        // TODO Auto-generated method stub
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setTitle(heading);
        actionBar.show();
    }

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView materialCalendarView, @NonNull CalendarDay calendarDay, boolean b) {
        todaysDate.setText("You are Viewing : "+ String.format("%02d",calendarDay.getDay())+"-"+String.format("%02d",calendarDay.getMonth()+1)+"-"+calendarDay.getYear());
        String toSend = calendarDay.getYear() + "-"+(calendarDay.getMonth()+1)+"-"+calendarDay.getDay();
        new TalkToDatabase(this,recyclerView,"Loading details for " + toSend).execute(toSend);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
