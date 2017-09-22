package com.branegy.populito.functions.exp;

import java.util.List;

import com.branegy.populito.Function;
import com.branegy.populito.SharedState;

public class OrExpression extends Function {
	
	List<Function> terms;

	public OrExpression(List<Function> terms) {
		this.terms= terms;
	}

    public Object nextValue() {
    	for (Function t : terms) {
    		if (toBoolean(t.nextValue())) {
    			return Boolean.TRUE;
    		}
    	}
    	return Boolean.FALSE;
    }

	@Override
	public void setState(SharedState state) {
		super.setState(state);
		for (Function f : terms) {
			f.setState(state);
		}
	}

	@Override
	public void setSeed(long seed) {
		super.setSeed(seed);
		for (Function f : terms) {
			f.setSeed(seed);
		}
	}
}
