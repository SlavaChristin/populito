package com.branegy.populito.functions;

import com.branegy.populito.Function;
import com.branegy.populito.SharedState;

public class LastName extends ListFromFile {
    Function gender;

    public LastName() {
        // super("functions/list/Name-LastName.txt");
    }

    @Override
    public void setState(SharedState state) {
        super.setState(state);
        if (gender!=null) {
            gender.setState(state);
        }
    }

    public void setGender(Function gender) {
        this.gender = gender;
    }

    @Override
    public Object nextValue() {
        String[] split = ((String) super.nextValue()).split(",");
        if (gender != null) {
            String gender_value = toString(gender.nextValue());
            while (!((gender_value.equals("M") && split[1].equals("male"))
                    || (gender_value.equals("F") && split[1].equals("female")))) {
                split = ((String) super.nextValue()).split(",");
            }
        }
        return split[0];
    }

}
