package com.example.gdg_4_lesson_home_work;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Павел on 12.12.2017.
 */

public class Realiz_assessments extends Assessment {
    public static int student_amount =25;
    public static Map<String,Integer> students = new HashMap<>(); //список студентов и их оценок



       static {


          for (int i = 0; i <student_amount;i++) {

              String symbols = "abc...xyz";
              StringBuilder randString = new StringBuilder();
              int count = (int)(Math.random()%30);
              for(int i=0;i<count;i++)
                  randString.append(symbols.charAt((int)(Math.random()*symbols.length())));
              students.put(randString.toString(), count%5);

          }
      }


    @Override
    public void set_assessment() {
        for (String std:students.keySet()
             ) {
  int result;
           result= (int) (check_prev_assessment(std)+ teacher_mood())/2;
 students.put(std,result);
        }

    }

    @Override
    protected int check_prev_assessment(String assessment) {


           return students.get(assessment);
    }

    public void printjornal(){
        System.out.println(students);
    }
}
