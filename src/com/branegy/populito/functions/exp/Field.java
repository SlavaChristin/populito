package com.branegy.populito.functions.exp;

import com.branegy.populito.Function;
import com.branegy.populito.SharedState;

public class Field extends Function {
    String parentName;
    String fieldName;
    int fieldIndex = -1;

    public Field(String fieldName, String parentName) {
        this.fieldName = fieldName;
        this.parentName = parentName;
        if (parentName!=null && !parentName.equals("parent")) {
            throw new RuntimeException("Only 'parent' supported for compound field names. Got "+parentName);
        }
    }
    
    @Override
    public void setState(SharedState state) {
        super.setState(state);
        if (parentName!=null) {
            // defer field index calculation as parent state is not available yet
            fieldIndex = -1;
        } else {
            fieldIndex = state.getFieldIndex(fieldName);
        }
    }
    
    public String getParentName() {
        return parentName;
    }

    @Override
    public Object nextValue() {
        if (parentName!=null) {
            SharedState parentState = state.getParentState();
            if (parentState==null) {
                throw new RuntimeException("Parent state is not set");
            }
            if (fieldIndex == -1) {
                fieldIndex = parentState.getFieldIndex(fieldName);
            }
            return parentState.values[fieldIndex];
        }
        return state.values[fieldIndex];
    }
    
    public String combinedName() {
        return (parentName == null ? "" : parentName+"." )+fieldName;
    }

}
