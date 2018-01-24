package com.example.gdg_lesson_home_work;

import java.util.Random;

/**
 * Created by Павел on 16.01.2018.
 */

public class Person {
    String name;
    String phoneNumber;
    int photo;
    Random random = new Random();

    public Person() {
        name = getRandStringNameAndFamil() + " " + getRandStringNameAndFamil();
        phoneNumber = getRandStringPhoneNumber();
        photo = R.mipmap.ic_launcher;
    }

    // Метод генерации имени и фамилии
    String getRandStringNameAndFamil() { //генерация имени
        String symbols = "абвгдеёжзийклмнопрстуфхцчшщьыъэюя";
        StringBuilder randString = new StringBuilder();

        for (int j = 0; j < (random.nextInt(11) + 3); j++) {
            randString.append(symbols.charAt(random.nextInt(symbols.length())));
        }
        if (randString.length() > 0) {
            randString.setCharAt(0, Character.toUpperCase(randString.charAt(0)));
        }
        return randString.toString();
    }

    // метод генерации номера телефона
    String getRandStringPhoneNumber() { //генерация номера
        StringBuilder randString = new StringBuilder();
        randString.append("+7");
        for (int j = 0; j < 10; j++) {
            randString.append(String.valueOf(random.nextInt(9)));
        }
        return randString.toString();
    }

}
