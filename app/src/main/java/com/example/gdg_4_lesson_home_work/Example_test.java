package com.example.gdg_4_lesson_home_work;

/**
 * Created by Павел on 12.12.2017.
 */

public class Example_test {
    public static void main(String[] args) {
        Realiz_assessments god_teacher = new Realiz_assessments();
        System.out.println("\n Журнал до новых оценок Хороший учитель \n");
        Bad_teacher bad_teacher =new Bad_teacher();
        System.out.println("\n Журнал до новых оценок Плохой учитель\n");
        //процессы выставления оценок
        god_teacher.set_assessment();
        bad_teacher.set_assessment();

        System.out.println("\n Хороший учитель:\n");
        god_teacher.printjornal();
        System.out.println("\n Плохой учитель:\n");

        bad_teacher.printjornal();
    }
}
