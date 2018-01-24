package com.example.gdg_lesson_home_work;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


/**
 * Created by Павел on 23.01.2018.
 */

public class AuthorizationFragment extends Fragment {
    OnActionListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_auth_main, container, false);

        //  объявление кнопки перехода на fragment 2
        Button nextActivityBtn = view.findViewById(R.id.buttonNext);

        //объявление кнопок соц.сетей
        ImageButton imgbtntwitter = view.findViewById(R.id.imgBtnTwitter);
        ImageButton imgbtnfacebook = view.findViewById(R.id.imgBtnFacebook);
        ImageButton imgbtngoogle = view.findViewById(R.id.imgBtnGoogle);

        //создание слушателей всех кнопок
        //кнопка твиттера
        imgbtntwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startUriActivity("https://twitter.com");
            }
        });

        //кнопка фейсбука
        imgbtnfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startUriActivity("https://facebook.com");
            }
        });

        //кнопка гугл
        imgbtngoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startUriActivity("https://google.com");

            }
        });

        //Обработка нажатия кнокпки перехода на 2й фрагмент
        nextActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onAction("KodeAuthAFragment");
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (OnActionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement OnActionListener");
        }
    }

    private void startUriActivity(String stringUri) {
        Uri addressfb = Uri.parse(stringUri);
        Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, addressfb);
        startActivity(openlinkIntent);

    }

}
