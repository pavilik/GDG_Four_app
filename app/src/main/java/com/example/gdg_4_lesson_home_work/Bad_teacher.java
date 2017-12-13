package com.example.gdg_4_lesson_home_work;

/**
 * Created by Павел on 12.12.2017.
 */

public class Bad_teacher extends Realiz_assessments { //класс плохого учителя, наследник хорошего учителя, только  "испортился" метод выставления оценок
    @Override
    public void set_assessment(){//переопределение метода выставления оценок для плохого учителя
        for (String std:students.keySet()
                ) {
            int result;
            result= (teacher_mood()+ fun_assessment(std))/2;
            students.put(std,result);
        }
    }

}
