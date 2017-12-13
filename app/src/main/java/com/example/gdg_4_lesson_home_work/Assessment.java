package com.example.gdg_4_lesson_home_work;

import static java.lang.Math.*;

/**
 * Created by Павел on 12.12.2017.
 */
//абстрактный класс оценивания
public abstract class Assessment {//класс выставления оценок
    int  field1; //оценка в числовом формате(A=5, B=4, C=3, D=2, F=1) //не использовано, зарезервированное поле для адаптации............. Ха, да просто для FUN
    String field2="Класс номер"; //
    boolean field3= false; ///флаг генерации журнала
    enum assessments {A,  B, C, D, F}; //перечисление оценок //не использовано, зарезервированное поле для адаптации.

    public abstract void set_assessment (); //метод выставления оценки в журнал

    protected abstract int  check_prev_assessment(String assessment);//проверка предыдущей оценки, принемает имя оцениваемого

   public int teacher_mood (){//метод выставления оценок
       int mood = (int) (random()*5);
       return mood;
   }

    protected int fun_assessment (String student_name){//метод для дополнительных манипуляций с оценками :) н
      if(check_prev_assessment(student_name)>3)
          return 5;
      else return 1;



    }
    private void set_class_name(){ //метод не используется невиден никому т.к. private(сделано для выполнения задания), а вообще должен сгенерировать номер класса
        field2=field2+"№"+ random()*10;
    }


}
