package com.branegy.populito.functions;

import com.branegy.populito.Function;


public class Constant extends Function {
    private final Object value;

    public Constant(Object value) {
        this.value = value;
    }

    @Override
    public Object nextValue()  {
        return value;
    }

}
