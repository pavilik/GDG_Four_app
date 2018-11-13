package com.example.home_work;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKList;

import org.json.JSONException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class MainActivity2Fragment extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener, Fragment2InputFIO.OnFragmentInteractionListener, MyItemRecyclerViewAdapter.OnItemClickListener {
    private static final String TAG = "!!!!!!!!!!!!!!!!!!!!!!!";
    //  @BindView(R.id.imageButton)
    // ImageButton imgBtnPlus;
    @BindView(R.id.buttonSort)
    Button buttonSort;

    @BindView(R.id.textViewEmptyList)
    TextView textViewEmptyList;

    @BindView(R.id.checkBox)
    CheckBox checkBox;

    public boolean sortStatus = true;

    List<CardFIONitem> cardFIONitems = new LinkedList<>();
    List<CardFIONitem> cardFIONitemsBack = new LinkedList<>();


    private String[] scope = new String[]{VKScope.FRIENDS, VKScope.PHOTOS};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //получение отпечатка
        //        String[] fingerprints = VKUtil.getCertificateFingerprint(this, this.getPackageName());
        //       System.out.println(Arrays.asList(fingerprints));

        VKSdk.login(this, scope);


        setContentView(R.layout.activity_main_activity2_fragment);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        goToNextFragment(new ItemFragment());

    }


    ///***********vktemplate
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
// Пользователь успешно авторизовался

                VKRequest vkRequest = VKApi.friends().get(VKParameters.from(VKApiConst.FIELDS, "id,first_name,has_photo,bdate"));
                vkRequest.executeSyncWithListener(new VKRequest.VKRequestListener() {
                    @Override
                    public void onComplete(VKResponse response) {
                        super.onComplete(response);
                        VKList vklist = (VKList) response.parsedModel;
                        SimpleDateFormat dtDDMMYYYY = new SimpleDateFormat("dd.MM.yyyy");
                        //В силу того, что не у всех друзей есть поле bdate (согласно документации ВК см. https://vk.com/dev/objects/user)
                        // принято условие установки тамим дату по умолчанию 1.1.0001
                        Date datei;
                        String bdate;
                        for (int i = 0; i < vklist.getCount(); i++) {
                            try {
                                //Добавление друзей в лист хранилища пользователей
                                ///Необходимо получить дату рождения в нужном формате
                                if (!(vklist.get(i).fields.has("bdate")))
                                    bdate = "1.1.0001";
                                else
                                    bdate = vklist.get(i).fields.get("bdate").toString();

                                if (bdate.length() > 4) {
                                    datei = dtDDMMYYYY.parse(bdate);
                                } else {
                                    //ВНИМАНИЕ, тут в получаемых данных не хватает года, поэтому устанавливаем год 0002.
                                    // данное допущение сделано для ускорения разработки
                                    //хорошем стилем было бы не участие данных друзей в сортировке по возрасту

                                    //так же можно было бы использовать поиск по друзьям
                                    // (см. поле birth_year  https://vk.com/dev/users.search) для создания списка друзей уже по возрастам (не используется т.к. увеличивает сложность запроса)
                                    //
                                    datei = dtDDMMYYYY.parse(bdate + ".0002");
                                }

                                CardFIONitem user = new CardFIONitem
                                        (
                                                //если любого поля не существует в запросе (кроме даты рождения), данный друг не будет добавлен в список
                                                vklist.get(i).fields.get("has_photo").toString(),
                                                vklist.get(i).fields.get("first_name").toString(),
                                                datei,
                                                vklist.get(i).fields.get("id").toString()
                                        );
                                //сразу добавляем элемент в список на отображение
                                onFragmentInteraction(user);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                });
            }

            @Override
            public void onError(VKError error) {
// Произошла ошибка авторизации (например, пользователь запретил авторизацию)
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    //*******


//    @OnClick(R.id.imageButton)
//    void addNewItem() {
//        }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @OnCheckedChanged(R.id.checkBox)
    void filterChange() {
        if (checkBox.isChecked()) {
            //установлена галочка фильтрация элементов списка друзей, необходимо убрать тех кто без фото
            cardFIONitemsBack.clear();
            cardFIONitemsBack.addAll(cardFIONitems);
            cardFIONitems.removeIf(cardFIONitem -> cardFIONitem.getHasPhoto().equals("0"));
            goToNextFragment(new ItemFragment());

        } else {
            //фильтр отключен вернуть в список ображения всех друзей 
            cardFIONitems.clear();
            cardFIONitems.addAll(cardFIONitemsBack);
            goToNextFragment(new ItemFragment());


        }
    }


    @TargetApi(Build.VERSION_CODES.N)
    @OnClick(R.id.buttonSort)
    void sortListUsers() {
        if (sortStatus) {
            //провести сортировку прямую

            //почистить отрисованные фрагменты

            for (Fragment fragment : getSupportFragmentManager().getFragments()) {
                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
            }

            //изменить статус сортировки на обратную
            sortStatus = false;

            // изменить текст кнопки на обратную сортировку
            buttonSort.setText("Сделать обратную сортировку по ДР");
            //проверить наличие данных в классе хранилище и сразу же сортировать
            if (!cardFIONitems.isEmpty())
                cardFIONitems.sort(Comparator.comparing(CardFIONitem::getBdate));

            //отрисовать текущее состояние
            goToNextFragment(new ItemFragment());
        } else {

            //почистить отрисованные фрагменты

            for (Fragment fragment : getSupportFragmentManager().getFragments()) {
                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
            }


            //сортировка листа обратная

            //проверить наличие данных в классе хранилище и сразу же сортировать
            if (!cardFIONitems.isEmpty())
                cardFIONitems.sort(Comparator.comparing(CardFIONitem::getBdate).reversed());
            //

            //изменить статус сортировки на обратную
            sortStatus = true;

            // изменить текст кнопки на прямую сортировку
            buttonSort.setText("Сделать прямую сортировку по ДР");
            //отрисовать текущее состояние
            goToNextFragment(new ItemFragment());
        }

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

    @Override
    public void onItemClick(CardFIONitem cardItem) {
        Log.d(TAG, "onClick " + cardItem.getNameFamili());
    }

    @Override
    public void onClick(View view) {

    }
}
