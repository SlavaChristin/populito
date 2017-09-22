package com.branegy.populito.functions.exp;

import java.util.List;

import com.branegy.populito.Function;
import com.branegy.populito.SharedState;

public class AndExpression extends Function {
	
	List<Function> terms;

	public AndExpression(List<Function> terms) {
		this.terms= terms;
	}

    public Object nextValue() {
    	for (Function t : terms) {
    		if (!toBoolean(t.nextValue())) {
    			return Boolean.FALSE;
    		}
    	}
    	return Boolean.TRUE;
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
