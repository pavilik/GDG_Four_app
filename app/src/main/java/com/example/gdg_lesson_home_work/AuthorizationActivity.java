package com.example.gdg_lesson_home_work;


import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;


public class AuthorizationActivity extends AppCompatActivity implements OnActionListener {


    @RequiresApi(api = Build.VERSION_CODES.M)
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
//
        //объявление тулбара
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        //активация кнопки назад и изменение цвета экшнбара
        ActionBar ab = getSupportActionBar();

        if (ab != null) {
            ab.setTitle("Авторизация");
            ab.setHomeButtonEnabled(true);
            ab.setDisplayHomeAsUpEnabled(true);
        }


        onAction("AuthorizationFragment");
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onAction(String strNextFrgmtName) {
        FragmentManager frMng = getSupportFragmentManager();
        FragmentTransaction transaction = frMng.beginTransaction();
        ActionBar ab = getSupportActionBar();

        switch (strNextFrgmtName) {
            case "AuthorizationFragment": {
                if (ab != null) {
                    ab.setBackgroundDrawable(new ColorDrawable(getColor(R.color.colorForMyActionBarZero)));
                }
                transaction.replace(R.id.container, new AuthorizationFragment());
            }
            break;

            case "KodeAuthAFragment": {
                if (ab != null) {
                    ab.setBackgroundDrawable(new ColorDrawable(getColor(R.color.colorForMyActionBar)));
                }
                transaction.replace(R.id.container, new KodeAuthFragment());
            }
            break;
            case "KontaktListAndFindFragment": {
                if (ab != null) {
                    ab.setTitle("Контакты");
                    ab.setBackgroundDrawable(new ColorDrawable(getColor(R.color.colorForMyActionBar2)));
                }

                transaction.replace(R.id.container, new KontaktListAndFindFragment());
            }
            break;

            default: {
                System.out.println("Нет распознанного имени фрагмента, загрузим первый");
                transaction.replace(R.id.container, new AuthorizationFragment());
            }
        }
        transaction.addToBackStack(null);
        transaction.commit();

    }

    //переопределение функции нажатия в экшн баре, на кнопку "домой" навешен возврат на предыдущий фрагмент по бэкстэку транзакций фрагмент менеджера (неужели этот комментария я сам написал...хм, в любом случае, так это у меня в голове)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getSupportFragmentManager().popBackStack();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
