package com.branegy.populito.functions.exp;

import com.branegy.populito.Function;
import com.branegy.populito.SharedState;

public class MathExpression extends Function {
	
	public enum MathOperator { PLUS,  MINUS, DIV, MULTIPLY, POWER, UNARY_MINUS } 
	
	Function left;
	MathOperator operator;
	Function right;
	
	public MathExpression(Function left, MathOperator operator, Function right) {
		this.left = left;
		this.operator = operator;
		this.right = right;
	}

    public Object nextValue() {
    	Object leftV = left.nextValue();
    	if (operator == MathOperator.UNARY_MINUS) {
        	throw new RuntimeException("Not implemented calculation");
    	} else {
    	
	    	Object rightV = right.nextValue();
	    	Object result;
	    	if (leftV instanceof Long & rightV instanceof Long) {
	    		Long leftVL = (Long)leftV;
	    		Long rightVL = (Long)rightV;
	    		switch (operator) {
	    			case PLUS:
	    				result = leftVL + rightVL;
	    				break;
	    			case MINUS:
	    				result = leftVL - rightVL;
	    				break;
	    			case MULTIPLY:
	    				result = leftVL * rightVL;
	    				break;
	    			case DIV :
	    				result = leftVL / rightVL;
	    				break;
	    			case POWER:
	    				result = Math.pow(leftVL, rightVL);
	    				break;
	    			default:
	    	        	throw new RuntimeException("Not implemented calculation");
	    		}
	    		return result;
	    	} else {
	    		
	    	}
        	throw new RuntimeException("Not implemented calculation");
    	}
    }

	@Override
	public void setState(SharedState state) {
		super.setState(state);
		left.setState(state);
		right.setState(state);
	}

	@Override
	public void setSeed(long seed) {
		super.setSeed(seed);
		left.setSeed(seed);
		right.setSeed(seed);
	}

}
