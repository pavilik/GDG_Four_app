package com.example.gdg4lessonhomework;

/**
 * Created by Павел on 13.12.2017.
 */

public class KlassZZ implements Jolie, Aniston {
    public int getLovers() {
        if (getPriznakpola()) {
            return 2;
        } else {
            return 0;
        }
    }

    public void getNameOfLovers() {
        System.out.println(Jolie.name + " и " + Aniston.name);
    }

    @Override
    public boolean getPriznakpola() {
        return (Jolie.pol ^ (Aniston.pol));
    }
}

