package com.example.gdg_4_lesson_home_work;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Павел on 12.12.2017.
 */

public class Realiz_assessments extends Assessment { //Класс реализации выставления оценок, генерирует  сам журнал и эмулирует работу нормального поведения учителя
    public static int student_amount;


    public Map<String, Integer> students = new HashMap<>(); //список студентов и их оценок


   protected   Realiz_assessments() {//генерация журнала
change_std_amo();


        for (int i = 0; i < student_amount; i++) {

            String symbols = "abcdefghijklmnopqrstuvwxyz";
            StringBuilder randString = new StringBuilder();
            int count;
            count = (int) (Math.random() * 15);
            for (int j = 0; j < count; j++)
                randString.append(symbols.charAt((int) (Math.random() * symbols.length())));

            Integer temp = 1 + (int) (Math.random() * 4);//случайно выставленная оценка
            students.put(randString.toString(), temp);

        }
        field3=true;//журнал сгенерирован

    }




    @Override
    public void set_assessment() {
        for (String std : students.keySet()
                ) {
            int result;
            result = (int) (check_prev_assessment(std) + teacher_mood() + fun_assessment(std)) / 3;
            students.put(std, result);
        }

    }

    @Override
    protected int check_prev_assessment(String assessment) {


        return students.get(assessment);
    }

    public void printjornal() {
        System.out.println(students);
    }

    public static void change_std_amo(){//статический паблик метод для выполнения задания
        student_amount=3+(int) Math.random()*3;

    }
}
