package com.example.gdg_4_lesson_home_work;

/**
 * Created by Павел on 13.12.2017.
 */

public class Klass3 implements Number2,Number3 {
    public int getLovers(){

        if (get_priznakpola())
        {
            return 2;
        } else return 0;

    }

    public void getNameOfLovers() {
        System.out.println(Number2.name + " и " + Number3.name);

    }
    @Override
    public boolean get_priznakpola() {
        return   (Number2.pol ^ Number3.pol);
    }

}
