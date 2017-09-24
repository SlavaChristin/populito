package com.branegy.populito.functions.exp;

import java.util.List;

import com.branegy.populito.Function;
import com.branegy.populito.SharedState;

public class LogicalExpression extends Function {
	
	private List<Function> terms;
	private LogicalOperator operator;
	
	public static enum LogicalOperator { OR, AND }; 
	

	public LogicalExpression(List<Function> terms, LogicalOperator operator) {
		this.terms= terms;
		this.operator = operator;
	}

    public Object nextValue() {
    	if (operator== LogicalOperator.OR ) {
	    	for (Function t : terms) {
	    		if (toBoolean(t.nextValue())) {
	    			return Boolean.TRUE;
	    		}
	    	}
	    	return Boolean.FALSE;
    	} else if (operator == LogicalOperator.AND) {
        	for (Function t : terms) {
        		if (!toBoolean(t.nextValue())) {
        			return Boolean.FALSE;
        		}
        	}
        	return Boolean.TRUE;    		
    	} else {
    		throw new RuntimeException("Operator "+operator+" is not supported");
    	}
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
