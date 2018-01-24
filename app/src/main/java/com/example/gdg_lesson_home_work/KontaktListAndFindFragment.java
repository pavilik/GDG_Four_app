package com.example.gdg_lesson_home_work;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by Павел on 24.01.2018.
 */

public class KontaktListAndFindFragment extends Fragment {
    OnActionListener listener;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kontakt_list_and_find, container, false);

        //объявление приватных переменных
        RecyclerView mRecyclerView;
        RecyclerView.Adapter mAdapter;
        RecyclerView.LayoutManager mLayoutManager;
        Person[] myDataset = getDataSet();

        mRecyclerView = view.findViewById(R.id.kontakt_recycler_view);

        // если мы уверены, что изменения в контенте не изменят размер layout-а RecyclerView
        // передаем параметр true - это увеличивает производительность
        mRecyclerView.setHasFixedSize(true);
        // используем linear layout manager
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        // создаем адаптер
        mAdapter = new RecyclerAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);


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

    private Person[] getDataSet() {
        Person[] mDataSet = new Person[30];
        for (int i = 0; i < mDataSet.length; i++) {
            mDataSet[i] = new Person();
        }
        return mDataSet;
    }

}
