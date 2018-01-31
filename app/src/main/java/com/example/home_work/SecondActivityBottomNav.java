package com.example.home_work;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


public class SecondActivityBottomNav extends AppCompatActivity implements OnActionListener {




    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {


            switch (item.getItemId()) {
                case R.id.bottom_nav_blank_fragment: {

                    onAction("blank");
                }

                return true;
                case R.id.bottom_nav_red_fragment: {

                    onAction("redFragment");
                }

                return true;
                case R.id.bottom_nav_tab_fragment: {

                    onAction("tabFragment");

                }

            }

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_bottom_nav);

        Toolbar toolbar2 = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);

       onAction("blank");

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onAction(String strAction) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


;



        switch (strAction) {

            case "redFragment": {
                fragmentTransaction.replace(R.id.fragment2, new RedFragment());

            }
            break;

            case "tabFragment": {



                fragmentTransaction.replace(R.id.fragment2, new TabAndPageViewFragment());
            }
            break;

            default:
                Fragment blank =new BlankFragment();
               fragmentTransaction.replace(R.id.fragment2, blank);

        }

        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();
    }

    @Override
    public void setToolbarText(String stringTextToolbar) {
        ActionBar ab2 = getSupportActionBar();
        if (ab2 != null) {
            ab2.setTitle(stringTextToolbar);
        }

    }

}
