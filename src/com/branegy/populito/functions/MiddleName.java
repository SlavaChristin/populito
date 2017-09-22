package com.branegy.populito.functions;

import com.branegy.populito.Function;

public class MiddleName extends Constant {
    Function gender;

    public MiddleName() {
        super("functions/list/Name-MiddleName.txt");
    }

    public void setGender(Function gender) {
        this.gender=gender;
    }

    @Override
    public Object nextValue() {
        return null;
    }

}
