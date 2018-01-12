package com.example.gdg_lesson_home_work;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class AuthorizationActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        //Объявление тулбара
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        //активация кнопки домаой в экшнбаре
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        //объявление кнопки перехода на актвити 2
        Button nextActivityBtn = (Button) findViewById(R.id.buttonNext);
        //объявление интента 2й активити
        final Intent startAuthKodeActivity = new Intent(this, KodeAuthActivity.class);

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
                Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, addressfb);
                startActivity(openlinkIntent);
            }
        });

        //кнопка гугл
        imgbtngoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri addressgg = Uri.parse("https://google.com");
                Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, addressgg);
                startActivity(openlinkIntent);
            }
        });

        //Обработка нажатия кнокпки перехода на 2ю активити
        nextActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Snackbar.make(view, "Я молодец!", Snackbar.LENGTH_SHORT)
//                        .addCallback(new Snackbar.Callback() {
//                            @Override
//                            public void onDismissed(Snackbar snackbar, int event) {
//                                startActivity(startAuthKodeActivity);
//                            }
//                        })
//                        .show();

                startActivity(startAuthKodeActivity);
            }
        });
    }
}
