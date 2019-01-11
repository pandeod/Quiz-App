package com.internship.scheduler.Activity.Faculty;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.util.Calendar;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

//to import R
import com.internship.scheduler.R;

public class ScheduleForm extends AppCompatActivity implements View.OnClickListener{

    private EditText mDateEditText;
    private EditText mTimeEditText;
    private EditText mTimeEditText1;

    private int mYear, mMonth, mDay, mHour, mMinute;
    private FloatingActionButton floatingActionButton;

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_form);

        //Show an X in place of <-
//        final Drawable cross = getResources().getDrawable(R.drawable.ic_clear_white_24dp);
//        if (cross != null) {
//            cross.setColorFilter(getResources().getColor(R.color.icons), PorterDuff.Mode.SRC_ATOP);
//        }
/*
    TODO : add back button
 */
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        this.setSupportActionBar(mToolbar);

//        if (this.getSupportActionBar() != null) {
//            Toast.makeText(this,"Nothing",Toast.LENGTH_LONG).show();
//            getSupportActionBar().setElevation(0);
//            getSupportActionBar().setDisplayShowTitleEnabled(false);
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setHomeAsUpIndicator(cross);
//        }

        mDateEditText = (EditText) findViewById(R.id.newTodoDateEditText);
        mTimeEditText = (EditText) findViewById(R.id.newTodoTimeEditText);
        mTimeEditText1 = (EditText) findViewById(R.id.newTodoTimeEditText1);

        mDateEditText.setOnClickListener(this);
        mTimeEditText.setOnClickListener(this);
        mTimeEditText1.setOnClickListener(this);

        floatingActionButton=findViewById(R.id.makeToDoFloatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_SHORT).show();
                //Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                //startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v==mDateEditText)
        {
            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            mDateEditText.setText(String.format("%02d", dayOfMonth) + "/" + String.format("%02d", (monthOfYear + 1))+ "/" + year);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        else if (v==mTimeEditText)
        {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                            mTimeEditText.setText(String.format("%02d",hourOfDay) + ":" + String.format("%02d",minute));
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
        else if (v==mTimeEditText1)
        {
            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                            mTimeEditText1.setText(String.format("%02d",hourOfDay) + ":" + String.format("%02d",minute));
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }
}
