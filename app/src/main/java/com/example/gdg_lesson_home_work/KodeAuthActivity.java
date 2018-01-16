package com.example.gdg_lesson_home_work;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


public class KodeAuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_kode);

        //объявление тулбара
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        //активация кнопки назад и изменение цвета экшнбара
        ActionBar ab = getSupportActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#c771767b")));
        //  ab.setBackgroundDrawable(new ColorDrawable(getColor(R.color.colorForMyActionBar)));
        ab.setDisplayHomeAsUpEnabled(true);


        //объявление кнопки перехода на 3ю активити
        Button btnUsrEntr = (Button) findViewById(R.id.buttonEntrance);

        //объявление интента прехода
        final Intent startKontaktListAndFind = new Intent(this, KontaktListAndFind.class);

        //Объявдение чекбокса
        final CheckBox checkUserAccept = (CheckBox) findViewById(R.id.checkBoxUserAccept);

        // Объявление окна уведомления
        final Toast toast = Toast.makeText(this, "Пользовательское соглашение не принято", Toast.LENGTH_LONG);

        //Обработка нажатия кнокпки перехода на 2ю активити
        btnUsrEntr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Проверка принятия пользовательского соглашения, если да, то переход на 3ю активити контактов
                if (checkUserAccept.isChecked()) {

                    Snackbar.make(view, "Я молодец!", Snackbar.LENGTH_SHORT)
                            .addCallback(new Snackbar.Callback() {
                                @Override
                                public void onDismissed(Snackbar snackbar, int event) {
                                    startActivity(startKontaktListAndFind);
                                }
                            })
                            .show();

                } else {

                    toast.show();

                }

            }
        });


    }
}
