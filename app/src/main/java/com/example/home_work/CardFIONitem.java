package com.example.home_work;

/**
 * Created by Павел on 06.02.2018.
 */

public class CardFIONitem {
    private String name;
    private String famili;
    private String otchestvo;
    private String numTel;


    public CardFIONitem(String inputName, String inputFamil, String inputOtchestvo, String inputNumTelel) {
        name = inputName;
        famili = inputFamil;
        otchestvo = inputOtchestvo;
        numTel = inputNumTelel;
    }

    public String getFamili() {
        return famili;
    }

    public String getName() {
        return name;
    }

    public String getNumTel() {
        return numTel;
    }

    public String getOtchestvo() {
        return otchestvo;
    }

}
