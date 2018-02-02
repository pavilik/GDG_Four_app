package com.example.home_work;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class RedFragment extends Fragment implements TitleUpdater {
    OnActionListener listener;

    String titleString;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_red, container, false);
        TextView textView = v.findViewById(R.id.textViewRedFragment);
        titleString = textView.getText().toString();
        updateActionBarTitle();
        return v;
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

    @Override
    public void updateActionBarTitle() {
        listener.setToolbarText(titleString);
    }
}
