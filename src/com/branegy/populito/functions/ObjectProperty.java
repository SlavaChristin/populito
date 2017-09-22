package com.branegy.populito.functions;

import java.util.Map;

import com.branegy.populito.Function;
import com.branegy.populito.SharedState;


public class ObjectProperty extends Function {
	
	private Function sourceObject;
	private String propertyName;

    public ObjectProperty() {
    }

    public void setObject(Function sourceObject)  {
        this.sourceObject = sourceObject;
    }
    
    public void setProperty(String propertyName) {
    	this.propertyName = propertyName;
    }

	@Override
	public Object nextValue() {
		Object value = sourceObject.nextValue();
		
		if (value==null) {
			return null;
		}
		Map<?,?> m = (Map<?,?>)value;
		
		
		return m.get(propertyName);
	}

	@Override
	public void setState(SharedState state) {
		super.setState(state);
		sourceObject.setState(state);
	}
	
	

}
