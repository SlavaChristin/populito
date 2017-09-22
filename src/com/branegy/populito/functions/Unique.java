package com.branegy.populito.functions;

import java.util.HashSet;

import com.branegy.populito.Function;
import com.branegy.populito.SharedState;

public class Unique extends Function {
    Function source;
    HashSet<Object> seenValues = new HashSet<>();

    @Override
    public Object nextValue() {
    	short i= (short)254;
    	while (i>0) {
    		Object nextValue = source.nextValue();
    		if (seenValues.add(nextValue)) {
    			return nextValue;
    		}
    		i--;
    	}
        throw new RuntimeException("Tried 255 times and coundn't generate a unique value");
    }
    
    public void setSource(Function source) {
    	this.source = source;
    }
    
    @Override
    public void setState(SharedState state) {
    	source.setState(state);
        super.setState(state);
    }
    
    public void setSeed(long seed) {
        rnd.setSeed(seed);
        source.setSeed(seed);
    }
    
    @Override
    public void reset() {
    	seenValues.clear();
    }
}