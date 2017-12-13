package com.example.gdg_4_lesson_home_work;

/**
 * Created by Павел on 12.12.2017.
 */

public class Example_test { //класс для процесса теста и выставления оценок
    public static void main(String[] args) {
        Realiz_assessments god_teacher = new Realiz_assessments();//создание объекта оценок учителя норм
        System.out.println("\nЖурнал до новых оценок Хороший учитель");
       System.out.println("Флаг генерации журнала = "+ god_teacher.field3);

        god_teacher.printjornal();
     //   god_teacher.set_class_name(); //можно  будет использовать только после изменения видимости в классе Assessment

        Bad_teacher bad_teacher =new Bad_teacher();//создание объекта оценок учителя плохого
        System.out.println("\nЖурнал до новых оценок Плохой учитель");
        System.out.println("Флаг генерации журнала = "+bad_teacher.field3);
        bad_teacher.printjornal();
     //   bad_teacher.set_class_name();//можно  будет использовать только после изменения видимости в классе Assessment


        //процессы выставления оценок
        god_teacher.set_assessment();
        bad_teacher.set_assessment();

        System.out.println("\n Хороший учитель:\n");
        god_teacher.printjornal();

        System.out.println("\n Плохой учитель:\n");
        bad_teacher.printjornal();
    }
}
