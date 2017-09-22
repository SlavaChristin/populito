package com.branegy.populito.functions.exp;

import com.branegy.populito.Function;
import com.branegy.populito.SharedState;

public class BooleanExpression extends Function {
	
	Function left;
	String operation;
	Function right;

	public BooleanExpression(Function left, String operation, Function right) {
		this.left = left;
		this.operation = operation;
		this.right = right;
	}
	
    public Object nextValue() {
		Object leftV = left.nextValue();
    	if (operation==null) {
    		if (leftV==null) {
    			throw new RuntimeException("Conditional value is null");
    		} else {
    	   		if (leftV instanceof Boolean) {
        			return leftV;
        		} else if (leftV.toString().equalsIgnoreCase("true")) {
        			return Boolean.TRUE;
        		} else if (leftV.toString().equalsIgnoreCase("false")) {
        			return Boolean.FALSE;
        		} else {
        	    	throw new RuntimeException("Unexpected value "+leftV);
        		}
    		}
    	} else {
    		Object rightV = right.nextValue();
    		if (rightV==null) {
    			if (operation.equals("=")) {
    				return Boolean.valueOf( leftV==null );
    			} else {
        			throw new RuntimeException("Cannot compare with at least one null");    				
    			}
    		} else {
    			if (operation.equals("=")) {
    				return leftV.equals(rightV);
    			} else if (operation.equals(">")) {
        				return Boolean.valueOf( toDouble(leftV) > toDouble(rightV));
    			} else if (operation.equals(">=")) {
    				return Boolean.valueOf( toDouble(leftV) >= toDouble(rightV));
    			} else if (operation.equals("<")) {
    				return Boolean.valueOf( toDouble(leftV) < toDouble(rightV));
    			} else if (operation.equals("<=")) {
    				return Boolean.valueOf( toDouble(leftV) <= toDouble(rightV));
    			} else {
        			throw new RuntimeException("Operation "+operation+"is not implemented");    				
    			}
    		}
    		
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
