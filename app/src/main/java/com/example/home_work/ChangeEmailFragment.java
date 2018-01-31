package com.example.home_work;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChangeEmailFragment extends Fragment {
OnActionListener listener;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

                View v = inflater.inflate(R.layout.fragment_change_email, container, false);
        Button bntChngEmail = v.findViewById(R.id.goChangeEmailFramment1);
   //   TextView textView = v.findViewById(R.id.enterEmailtextView);
    //  listener.setToolbarText(textView.getText().toString());

        bntChngEmail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

listener.onAction("changeEmailAccept");


            }


        });
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
}
