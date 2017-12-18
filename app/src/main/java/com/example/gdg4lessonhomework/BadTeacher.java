package com.example.gdg4lessonhomework;

/**
 * Created by Павел on 12.12.2017.
 */

public class BadTeacher extends RealizAssessments { //класс плохого учителя, наследник хорошего учителя, только  "испортился" метод выставления оценок
    @Override
    public void setAssessment() {//переопределение метода выставления оценок для плохого учителя
        for (String std : students.keySet()
                ) {
            int result;
            result = (teacherMood() + fun_assessment(std)) / 2;
            students.put(std, result);
        }
    }
}
