package com.branegy.populito.functions;

import com.branegy.populito.Function;

/**
 * Generates a random value between <code>min</code> and <code>max</code>
 */
public class Interval extends Function {

    Function min;
    Function max;
    String type = "long";

    @Override
    public void setSeed(long seed) {
        super.setSeed(seed);
        min.setSeed(seed);
        max.setSeed(seed);
    }

    public void setMin(Function min) {
        this.min = min;
    }

    public void setMax(Function max) {
        this.max = max;
    }
    
    public void setType(String type) {
       this.type = type;
    }
    
    @Override
    public Object nextValue() {
        if (type.equals("long")) {
            long min = toLong(this.min.nextValue());
            long max = toLong(this.max.nextValue());
            return new Long(min+Math.round(rnd.nextFloat()*(max-min)));
        } else {
            double min = toDouble(this.min.nextValue());
            double max = toDouble(this.max.nextValue());
            return new Double(min+rnd.nextFloat()*(max-min));
        }
    }

}
