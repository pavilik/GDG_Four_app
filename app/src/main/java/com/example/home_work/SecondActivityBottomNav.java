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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.first_activity_nav_draw, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int colorId = 0;
        int id = item.getItemId();

        if (id == R.id.ColorOne) {
            colorId = R.color.zelenii;
            Toast.makeText(getApplicationContext(),
                    "Зеленый", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.ColorTwo) {
            colorId = R.color.sinii;
            Toast.makeText(getApplicationContext(),
                    "Синий", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.ColorThree) {
            colorId = R.color.fioletovii;
            Toast.makeText(getApplicationContext(),
                    "Фиолетовый", Toast.LENGTH_SHORT).show();
        }

        if (colorId != 0) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            View v = fragmentManager.findFragmentById(R.id.fragment2).getView();
            if (v != null) {
                v.setBackgroundResource(colorId);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onAction(String strAction) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
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
                Fragment blank = new BlankFragment();
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
