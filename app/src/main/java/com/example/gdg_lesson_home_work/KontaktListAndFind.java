package com.example.gdg_lesson_home_work;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.LinearLayoutManager;

public class KontaktListAndFind extends AppCompatActivity {

    //объявление приватных переменных
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontakt_list_and_find);

        //объявление тулбара
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        //активация кнопки назад и изменение цвета экшнбара
        ActionBar ab = getSupportActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#c745484b")));
        //  ab.setBackgroundDrawable(new ColorDrawable(getColor(R.color.colorForMyActionBar)));
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("Контакты");

        Person[] myDataset = getDataSet();

        mRecyclerView = (RecyclerView) findViewById(R.id.kontakt_recycler_view);

        // если мы уверены, что изменения в контенте не изменят размер layout-а RecyclerView
        // передаем параметр true - это увеличивает производительность
        mRecyclerView.setHasFixedSize(true);
        // используем linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // создаем адаптер
        mAdapter = new RecyclerAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }

    private Person[] getDataSet() {
        Person[] mDataSet = new Person[30];
        for (int i = 0; i < mDataSet.length; i++) {
            mDataSet[i] = new Person();
        }
        return mDataSet;
    }
}
