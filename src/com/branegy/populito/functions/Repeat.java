package com.branegy.populito.functions;

import com.branegy.populito.Function;
import com.branegy.populito.SharedState;

public class Repeat extends Function {
    private Function valueF;
    private Function count;
    private long repeat;
    private Object value;

    @Override
    public Object nextValue() {
        if (repeat==0) {
           value = valueF.nextValue();
           repeat = toLong(count.nextValue());
        }
        repeat--;
        return value;
    }

    public void setValue(Function value) {
        this.valueF = value;
    }

    public void setCount(Function function) {
        this.count = function;
    }

    @Override
    public void setState(SharedState state) {
        valueF.setState(state);
        super.setState(state);
    }

}
