package com.example.gdg_lesson_home_work;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class AuthorizationActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        ActionBar actionBar =getSupportActionBar();
        actionBar.setTitle("@string/nameauthActivityKode");

        //объявление кнопки перехода на актвити 2
        Button nextActivityBtn = (Button) findViewById(R.id.buttonNext);
        //объявление интента 2й активити
       final Intent startAuthKodeActivity = new Intent (this,AuthKodeActivity.class);


        //объявление кнопок соц.сетей
        ImageButton imgbtntwitter = (ImageButton) findViewById(R.id.imgBtnTwitter);
        ImageButton imgbtnfacebook = (ImageButton) findViewById(R.id.imgBtnFacebook);
        ImageButton imgbtngoogle = (ImageButton) findViewById(R.id.imgBtnGoogle);

        //создание слушателей всех кнопок
        //кнопка твиттера
        imgbtntwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri addresstw = Uri.parse("https://twitter.com");
                Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, addresstw);
                startActivity(openlinkIntent);

            }
        });
        //кнопка фейсбука
        imgbtnfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri addressfb = Uri.parse("https://facebook.com");
                Intent openlinkIntent = new Intent(Intent.ACTION_VIEW,addressfb);
                startActivity(openlinkIntent);
            }
        });
        //кнопка гугл
        imgbtngoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri addressgg = Uri.parse("https://google.com");
                Intent openlinkIntent = new Intent(Intent.ACTION_VIEW,addressgg);
                startActivity(openlinkIntent);
            }
        });

        nextActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(startAuthKodeActivity);
            }
        });
    }
}
