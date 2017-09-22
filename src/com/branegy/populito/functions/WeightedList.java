package com.branegy.populito.functions;

import java.util.List;

import com.branegy.populito.Function;
import com.branegy.populito.SharedState;

public class WeightedList extends Function {
    List<Function> values;
    List<Function> weights;
    double[] weightsValues;
    double  totalWeight;

    @Override
    public Object nextValue() {
    	double w = rnd.nextDouble() * totalWeight;
    	for (int i=0; i< weightsValues.length; i++ ) {
    		if (weightsValues[i]>=w) {
    			return values.get(i).nextValue();
    		}
    	}
        throw new RuntimeException("Ups. This code should never be reached");
    }

    @Override
    public void setState(SharedState state) {
    	if (values==null || weights==null) {
    		throw new RuntimeException("Values or weights cannot be null");    		
    	}
    	if (values.size()!= weights.size() ) {
    		throw new RuntimeException("Values and weights have different lenght "+values.size()+" vs "+weights.size());    		
    	}

    	weightsValues = new double[weights.size()];
        
    	super.setState(state);
        for (Function v : values) {
        	v.setState(state);
        }
        for (Function v : weights) {
        	v.setState(state);
        }
        weightsValues[0] = toDouble(weights.get(0).nextValue()); 
        totalWeight = weightsValues[0]; 
        for (int i=1; i<weights.size(); i++) {        	
            weightsValues[i] = toDouble(weights.get(i).nextValue());
            totalWeight += weightsValues[i]; 
            weightsValues[i] += weightsValues[i-1];
        }      
    }
       
    public void setSeed(long seed) {
        rnd.setSeed(seed);
        for (Function v : values) {
        	v.setSeed(rnd.nextLong());
        }
        for (Function v : weights) {
        	v.setSeed(rnd.nextLong());
        }
    }
    
    public void setValues(Function values) {
        if (values instanceof ListFunction) {
			this.values = ((ListFunction)values).getValues();
        } else {        	
        	throw new IllegalArgumentException("Expecting a list for values"); 
        }        
    }

    public void setWeights(Function weights) {
        if (weights instanceof ListFunction) {
			this.weights = ((ListFunction)weights).getValues();
        } else {
        	throw new IllegalArgumentException("Expecting a list for weights"); 
        }        
    }

}
