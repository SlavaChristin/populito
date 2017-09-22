package com.branegy.populito.functions.exp;

import com.branegy.populito.Function;
import com.branegy.populito.SharedState;

public class ConditionalExpression extends Function {
	
	Function condition;
	Function whenTrue;
	Function whenFalse;

	public ConditionalExpression(Function condition, Function whenTrue, Function whenFalse) {
		this.condition = condition;
		this.whenFalse = whenFalse;
		this.whenTrue = whenTrue;
	}
	
    public Object nextValue() {
    	Object value = condition.nextValue();
    	if (value instanceof Boolean) {
    		value = ((Boolean)value) ? whenTrue.nextValue() : whenFalse.nextValue();
    	}
    	return value;
    }

	@Override
	public void setState(SharedState state) {
		super.setState(state);
		condition.setState(state);
		whenFalse.setState(state);
		whenTrue.setState(state);
	}

	@Override
	public void setSeed(long seed) {
		super.setSeed(seed);
		condition.setSeed(seed);
		whenFalse.setSeed(seed);
		whenTrue.setSeed(seed);
	}
}
