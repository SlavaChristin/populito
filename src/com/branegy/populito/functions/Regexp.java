package com.branegy.populito.functions;

import com.branegy.populito.Function;
import com.branegy.populito.SharedState;
import com.mifmif.common.regex.Generex;

public class Regexp extends Function {
    private Function pattern;
    private Generex generex;
    
    @Override
    public void setState(SharedState state) {
        this.state = state;
        setSeed(5124123);
    }
       
    public void setSeed(long seed) {
        rnd.setSeed(seed);
        String patternValue = toString(pattern.nextValue());
        try {
        	generex = new Generex(patternValue, rnd );
        } catch (Exception e) {
        	throw new RuntimeException("Cannot initialize generator for pattern " + patternValue);
        }
    }

    @Override
    public Object nextValue() {
        try {
        	return generex.random();
        } catch (Exception e) {
        	throw new RuntimeException("Cannot generate value for pattern "+pattern.nextValue());
        }
    }
    
    public void setPattern(Function pattern) {
        this.pattern = pattern;
    }


}
