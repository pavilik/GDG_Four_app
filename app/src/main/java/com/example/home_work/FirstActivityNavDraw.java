package com.example.home_work;


import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.makeText;


public class FirstActivityNavDraw extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnActionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_nav_draw);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        onAction("покажи пустоту ;) ну или хотябы бланк_фрагмент");

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.first_activity_nav_draw, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int colorId = 0;
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
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
            View v = fragmentManager.findFragmentById(R.id.container).getView();
            if (v != null) {
                v.setBackgroundResource(colorId);
            }
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.change_email) {
            onAction("drowChangeEmail");
        } else if (id == R.id.red_fragment) {
            onAction("redFragment");
        } else if (id == R.id.blank_fragment) {
            onAction("Пустой");
        } else if (id == R.id.next_mng_act) {
            startActivity(new Intent(this, SecondActivityBottomNav.class));
        }

        setToolbarText(item.getTitle().toString());
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onAction(String strAction) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (strAction) {
            case "changeEmailAccept": {
                TextView emailNav = findViewById(R.id.emailTextViewInNavigation);
                TextView textEditInF1 = findViewById(R.id.inputEmailEditTextFragment1);
                emailNav.setText(textEditInF1.getText());
                fragmentTransaction.replace(R.id.container, new BlankFragment());
            }
            break;
            case "drowChangeEmail": {
                fragmentTransaction.replace(R.id.container, new ChangeEmailFragment());
            }
            break;
            case "redFragment": {
                fragmentTransaction.replace(R.id.container, new RedFragment());
            }
            break;
            default:
                fragmentTransaction.replace(R.id.container, new BlankFragment());
        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void setToolbarText(String stringTextToolbar) {
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(stringTextToolbar);
        }
    }
}
