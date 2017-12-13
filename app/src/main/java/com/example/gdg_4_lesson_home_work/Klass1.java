package com.example.gdg_4_lesson_home_work;

/**
 * Created by Павел on 13.12.2017.
 */

public class Klass1 implements Number1,Number2 {
    @Override
    public boolean get_priznakpola() {
        return (Number1.pol ^ Number2.pol);
    }

    public int getLovers() {

        if (get_priznakpola()) {
            return 2;
        } else return 0;

    }

    public void getNameOfLovers() {
        System.out.println(Number1.name + " и " + Number2.name);

    }
}