package com.internship.scheduler;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.internship.scheduler.Activity.Faculty.FacultyHome;
import com.internship.scheduler.Activity.Student.StudentHome;

public class MainActivity extends AppCompatActivity {

    private String uEmail;
    private String uPassword;
    boolean opr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView signUp=findViewById(R.id.student_signin);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),StudentHome.class));
                //built in android fade in-out animation
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        });

        Button bt=findViewById(R.id.btn_login);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ed1=findViewById(R.id.input_email);
                EditText ed2=findViewById(R.id.input_password);
                uEmail=ed1.getText().toString();
                uPassword=ed2.getText().toString();

                Toast.makeText(getApplicationContext(),uEmail+"  "+uPassword,Toast.LENGTH_LONG).show();

                if(TextUtils.isEmpty(uEmail)||TextUtils.isEmpty(uPassword))
                    opr=false;
                else {
                    opr=(uEmail.equals("faculty") && uPassword.equals("12345"))?true:false;
                }

                if(opr)
                {
                    //showMessage("Successful !","Log In Successful !!!");
                    startActivity(new Intent(getApplicationContext(), FacultyHome.class));
                    //built in android fade in-out animation
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                }
                else
                {
                    showMessage("Log In Failed !", "Please check log-in credentials...");
                }
            }
        });

    }

    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("ok",null);
        builder.show();
    }
}
