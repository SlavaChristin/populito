package com.branegy.populito.functions;

import java.util.Random;

public abstract class Function {
    // State state;
    Random rnd = new Random();

    public abstract Object nextValue();

    //public void setState(State state) {
    //    this.state = state;
    //}

    public void setSeed(long seed) {
        rnd.setSeed(seed);
    }

    public long toLong(Object object) {
        if (object instanceof Long) {
            return ((Long) object).longValue();
        } else if (object != null) {
            return Long.parseLong(object.toString());
        } else {
            throw new RuntimeException("Null cannot be converted to long");
        }
    }

    public String toString(Object object) {
        return object == null ? null : object.toString();
    }

}
