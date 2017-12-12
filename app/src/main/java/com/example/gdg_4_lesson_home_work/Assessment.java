package com.example.gdg_4_lesson_home_work;

/**
 * Created by Павел on 12.12.2017.
 */
//абстрактный класс оценивания
public abstract class Assessment {
    int  field1; //оценка в числовом формате(A=5, B=4, C=3, D=2, F=1)
    String field2="no_name"; //имя ученика
    boolean field3= true; ///флаг выставления оценки
    enum assessments {A,  B, C, D, F}; //перечисление оценок

    public abstract void set_assessment (); //метод выставления оценки в журнал

    protected abstract int  check_prev_assessment(String assessment);//проверка предыдущей оценки, принемает имя оцениваемого

   public int teacher_mood (){//метод выставления оценок
       int mood = (int) (Math.random()%5);
       return mood;
   }

    private int fun_assessment (String student_name){//метод для дополнительных манипуляций с оценками :)
      if(check_prev_assessment(student_name)>3)
          return 5;
      else return 1;



    }


}
