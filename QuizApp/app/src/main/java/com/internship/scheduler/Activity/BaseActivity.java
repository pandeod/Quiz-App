package com.internship.scheduler.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.internship.scheduler.R;

public class BaseActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.float_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
//            case R.id.action_schedule:
//                goToSchedule();
//                return true;
            case R.id.action_setting:
                goToSetting();
            case R.id.action_about:
                goToAbout();
                return true;
        }

        return true;
    }

//    private void goToSchedule() {
//        startActivity(new Intent(getApplicationContext(),ScheduleForm.class));
//        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//        finish();
//    }

    private void goToSetting(){
        startActivity(new Intent(getApplicationContext(),About.class));
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

    private void goToAbout(){
        startActivity(new Intent(getApplicationContext(),About.class));
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

}
