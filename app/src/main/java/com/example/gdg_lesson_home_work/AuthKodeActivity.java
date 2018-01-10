package com.example.gdg_lesson_home_work;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class AuthKodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_kode);


        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
         ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#c771767b")));
      //  ab.setBackgroundDrawable(new ColorDrawable(getColor(R.color.colorForMyActionBar)));
       ab.setDisplayHomeAsUpEnabled(true);


    }
}
