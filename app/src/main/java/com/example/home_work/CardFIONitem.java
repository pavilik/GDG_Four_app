package com.example.home_work;

import java.util.Date;

/**
 * Created by Павел on 06.02.2018.
 */

public class CardFIONitem {
    private String hasPhoto;//поле наличия фото 1-есть, 0-нет фото
    private String nameFamili;//имя друга
    private Date bdate;//Дата рождения если есть, получение данного поля условное см. разбор респонса от ВК
    private String numId;//идентификатор друга в ВК


    public CardFIONitem(String inputHasPhoto, String inputNameFamil, Date inputBdate, String inputNumId) {
        hasPhoto = inputHasPhoto;
        nameFamili = inputNameFamil;
        bdate = inputBdate;
        numId = inputNumId;
    }


    public String getHasPhoto() {
        return hasPhoto;
    }

    public String getNameFamili() {
        return nameFamili;
    }

    public Date getBdate() {
        return bdate;
    }

    public String getNumId() {
        return numId;
    }

}
