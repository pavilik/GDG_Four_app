package com.example.gdg_lesson_home_work;

/**
 * Created by Павел on 16.01.2018.
 */

public class Person {
    String name;
    String phoneNumber;
    int photo;

    public Person() {
        name = getRandStringNameAndFamil() + " " + getRandStringNameAndFamil();
        phoneNumber = getRandStringPhoneNumber();
        photo = R.mipmap.ic_launcher;
    }

    // Метод генерации имени и фамилии
    String getRandStringNameAndFamil() { //генерация имени
        String symbols = "абвгдеёжзийклмнопрстуфхцчшщьыъэюя";
        StringBuffer randString = new StringBuffer();
        int count;
        count = (int) (Math.random() * 12) + 3;
        for (int j = 0; j < count; j++) {
            randString.append(symbols.charAt((int) (Math.random() * symbols.length())));
        }
        if (randString.length() > 0)
            randString.setCharAt(0, Character.toUpperCase(randString.charAt(0)));

        return randString.toString();
    }

    // метод генерации номера телефона
    String getRandStringPhoneNumber() { //генерация номера
        String symbols = "0123456789";
        StringBuilder randString = new StringBuilder();
        randString.append("+7");
        for (int j = 0; j < 10; j++) {
            randString.append(symbols.charAt((int) (Math.random() * symbols.length())));
        }
        return randString.toString();
    }

}
