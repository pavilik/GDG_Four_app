package com.example.gdg4lessonhomework;

/**
 * Created by Павел on 12.12.2017.
 */

public class ExampleTest { //класс для процесса теста и выставления оценок
    public static void main(String[] args) {
        RealizAssessments godTeacher = new RealizAssessments();//создание объекта оценок учителя норм
        System.out.println("\nЖурнал до новых оценок Хороший учитель");
        System.out.println("Флаг генерации журнала = " + godTeacher.field3);

        godTeacher.printjornal();
        //   godTeacher.set_class_name(); //можно  будет использовать только после изменения видимости в классе Assessment

        BadTeacher badTeacher = new BadTeacher();//создание объекта оценок учителя плохого
        System.out.println("\nЖурнал до новых оценок Плохой учитель");
        System.out.println("Флаг генерации журнала = " + badTeacher.field3);
        badTeacher.printjornal();
        //   badTeacher.set_class_name();//можно  будет использовать только после изменения видимости в классе Assessment


        //процессы выставления оценок
        godTeacher.setAssessment();
        badTeacher.setAssessment();

        System.out.println("\n Хороший учитель:\n");
        godTeacher.printjornal();

        System.out.println("\n Плохой учитель:\n");
        badTeacher.printjornal();

        ////////////////Раздел тестирования Интерфейсов
        KlassMZ variantMZ = new KlassMZ();//вариант класса в котором интерфейсы с Ж (pol = true) и M (pol = false)
        KlassZZ variantZZ = new KlassZZ();// вариант класса в котором интерфейсы Ж (pol = true) и Ж (pol = true)
        KlassZM variantZM = new KlassZM(); // вариант  класса в котором интерфейсы М (pol = false) и Ж (pol = true)

        System.out.println("\nЗадание №2 вывод результатов: ");

        switch (variantMZ.getLovers()) {
            case 2:
                variantMZ.getNameOfLovers();
                break;
            case 0:
                System.out.println("ОМГ, а так можно?");
                break;
            default:
                System.out.println("что то  не так");
        }
        switch (variantZZ.getLovers()) {
            case 2:
                variantZZ.getNameOfLovers();
                break;
            case 0:
                System.out.println("ОМГ, а так можно?");
                break;
            default:
                System.out.println("что то  не так");
        }
        switch (variantZM.getLovers()) {
            case 2:
                variantZM.getNameOfLovers();
                break;
            case 0:
                System.out.println("ОМГ, а так можно?");
                break;
            default:
                System.out.println("что то  не так");
        }
    }
}
