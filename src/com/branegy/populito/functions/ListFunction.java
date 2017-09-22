package com.branegy.populito.functions;

import java.util.List;

import com.branegy.populito.Function;
import com.branegy.populito.OutOfRowsException;


public class ListFunction extends Function {
	List<Function> values;

    String order = "random";
    
    int pointer = 0;
    
    boolean loop = true;

    public void setOrder(String order) {
        this.order = order;
    }

	public void setValues(List<Function> values) {
		this.values = values;
	}

	public List<Function> getValues() {
		return values;
	}
	
	public void setLoop(String loop) {
		this.loop = Boolean.valueOf(loop);
	}
   
    
    @Override
    public Object nextValue() {
        int index;
        if (order.equals("random")) {
            index = (int) (rnd.nextFloat() * values.size());
        } else {
            index = pointer;
            pointer++;
            if (pointer==values.size() && loop) {
                pointer = 0;
            }
            if (pointer > values.size()) {
            	throw new OutOfRowsException("All values were used from the list");
            }
        }
        return values.get(index).nextValue();
    }


}
