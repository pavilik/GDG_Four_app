package com.example.gdg4lessonhomework;

/**
 * Created by Павел on 13.12.2017.
 */

public class KlassZM implements BredPit, Aniston {
    public int getLovers() {
        if (getPriznakpola()) {
            return 2;
        } else {
            return 0;
        }
    }

    public void getNameOfLovers() {
        System.out.println(BredPit.name + " и " + Aniston.name);
    }

    @Override
    public boolean getPriznakpola() {
        return (BredPit.pol ^ Aniston.pol);
    }
}
