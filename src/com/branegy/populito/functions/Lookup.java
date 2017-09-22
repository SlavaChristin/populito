package com.branegy.populito.functions;

import com.branegy.populito.Function;
import com.branegy.populito.SharedState;

public class Lookup extends Function {
    Function hash;
    Function key;
    String attribute;

    @Override
    public void setState(SharedState state) {
        super.setState(state);
        hash.setState(state);
        key.setState(state);
    }

    public void setHash(Function table) {
        this.hash = table;
    }

    public void setKey(Function key) {
        this.key = key;
    }

    public void setAttribute(Function attribute) {
        this.attribute = toString(attribute.nextValue());
    }

    // ^Lookup(table=assignments,key=assignmentID,attribute="taskID")

    @Override
    public Object nextValue() {
        IHash nextValue = (IHash) hash.nextValue();
        return nextValue.getAttributeValue(key.nextValue(), attribute);
    }

}
