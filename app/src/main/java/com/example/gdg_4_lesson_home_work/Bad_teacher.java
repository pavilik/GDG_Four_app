package com.example.gdg_4_lesson_home_work;

/**
 * Created by Павел on 12.12.2017.
 */

public class Bad_teacher extends Realiz_assessments {
    @Override
    public void set_assessment(){
        for (String std:students.keySet()
                ) {
            int result;
            result= teacher_mood();
            students.put(std,result);
        }
    }

}
