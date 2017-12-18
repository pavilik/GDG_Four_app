package com.example.gdg4lessonhomework;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Павел on 12.12.2017.
 */

public class RealizAssessments extends Assessment { //Класс реализации выставления оценок, генерирует  сам журнал и эмулирует работу нормального поведения учителя
    public static int student_amount;


    public Map<String, Integer> students = new HashMap<>(); //список студентов и их оценок


    protected RealizAssessments() {//генерация журнала
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
        field3 = true;//журнал сгенерирован

    }


    @Override
    public void setAssessment() {
        for (String std : students.keySet()
                ) {
            int result;
            result = (int) (checkPrevAssessment(std) + teacherMood() + fun_assessment(std)) / 3;
            students.put(std, result);
        }

    }

    @Override
    protected int checkPrevAssessment(String assessment) {


        return students.get(assessment);
    }

    public void printjornal() {
        System.out.println(students);
    }

    public static void change_std_amo() {//статический паблик метод для выполнения задания
        student_amount = 3 + (int) Math.random() * 3;

    }
}
