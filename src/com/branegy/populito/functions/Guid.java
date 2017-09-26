package com.branegy.populito.functions;

import com.branegy.populito.Function;

/**
 * Generates a sql server GUID
 */

// TODO Implement seed

public class Guid extends Function {

    @Override
    public Object nextValue() {    	
    	return java.util.UUID.randomUUID().toString().toUpperCase();
    }

}
