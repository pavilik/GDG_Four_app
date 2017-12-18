package com.example.gdg4lessonhomework;

/**
 * Created by Павел on 13.12.2017.
 */

public class KlassMZ implements Jolie, BredPit {
    @Override
    public boolean getPriznakpola() {
        return (Jolie.pol ^ BredPit.pol);
    }

    public int getLovers() {
        if (getPriznakpola()) {
            return 2;
        } else {
            return 0;
        }
    }

    public void getNameOfLovers() {
        System.out.println(Jolie.name + " и " + BredPit.name);
    }
}