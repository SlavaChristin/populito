package com.branegy.populito.functions;

import com.branegy.populito.Function;
import com.branegy.populito.OutOfRowsException;

public class Distinct extends Function {
    Function[] array;
    int len;

    @Override
    public Object nextValue() {
        if (array!=null) {
            if (len==0) {
                throw new OutOfRowsException("No more values left");
            }
            int index = (int)(rnd.nextFloat()*(len-1));
            Object next = array[index].nextValue();
            array[index] = array[--len];
            return next;
        }
        throw new RuntimeException("Not implemented");
    }

    public void setList(Function list) {
        if (list instanceof ListFunction) {
            array = (Function[])((ListFunction)list).getValues().toArray();
            len = array.length;
        } else {
        	throw new IllegalArgumentException("Expecting a list"); 
        }        
    }

}
