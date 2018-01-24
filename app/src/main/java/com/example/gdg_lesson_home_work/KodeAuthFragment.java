package com.example.gdg_lesson_home_work;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


public class KodeAuthFragment extends Fragment {
    OnActionListener listener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_auth_kode, container, false);

        //объявление кнопки перехода на 3ю активити
        Button btnUsrEntr = view.findViewById(R.id.buttonEntrance);

        //Объявдение чекбокса
        final CheckBox checkUserAccept = view.findViewById(R.id.checkBoxUserAccept);

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
                                    listener.onAction("KontaktListAndFindFragment");
                                }
                            })
                            .show();

                } else {

                    Toast.makeText(view.getContext(), "Пользовательское соглашение не принято", Toast.LENGTH_LONG).show();

                }

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

}
