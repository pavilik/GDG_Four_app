package com.example.home_work;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity2Fragment extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener, Fragment2InputFIO.OnFragmentInteractionListener {
    @BindView(R.id.imageButton)
    ImageButton imgBtnPlus;

    @BindView(R.id.textViewEmptyList)
    TextView textViewEmptyList;

    List<CardFIONitem> cardFIONitems = new LinkedList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_fragment);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        goToNextFragment(new ItemFragment());

    }

    @OnClick(R.id.imageButton)
    void addNewItem() {

        goToNextFragment(new Fragment2InputFIO());

    }

    @Override

    public List<CardFIONitem> onListFragmentInteraction() {
        return cardFIONitems;
    }

    @Override
    public void onFragmentInteraction(CardFIONitem cardFIONitem) {

        cardFIONitems.add(cardFIONitem);

        goToNextFragment(new ItemFragment());
    }


    private void goToNextFragment(Fragment fragment) {

        if (!cardFIONitems.isEmpty()) {
            textViewEmptyList.setVisibility(View.INVISIBLE);
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containerFragments, fragment);
        fragmentTransaction.commit();

    }

}
