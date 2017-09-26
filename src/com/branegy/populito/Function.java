package com.branegy.populito;

import java.util.Random;

public abstract class Function {
    protected SharedState state;

    protected Random rnd = new Random();

    public abstract Object nextValue();

    public void setState(SharedState state) {
        this.state = state;
    }

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

    public double toDouble(Object object) {
        if (object instanceof Double) {
            return ((Double) object).doubleValue();
        } else if (object != null) {
            return Double.parseDouble(object.toString());
        } else {
            throw new RuntimeException("Null cannot be converted to double");
        }
    }
    
    public Boolean toBoolean(Object object) {
        if (object==null) {
            throw new RuntimeException("Boolean cannot be null");
        }
           if (object instanceof Boolean) {
            return (Boolean)object;
        } else if (object.toString().equalsIgnoreCase("true")) {
            return Boolean.TRUE;
        } else if (object.toString().equalsIgnoreCase("false")) {
            return Boolean.FALSE;
        } else {
            throw new RuntimeException("Unexpected boolean value "+object);
        }
    }

    public String toString(Object object) {
        return object == null ? null : object.toString();
    }

    public void reset() {
    }

}
