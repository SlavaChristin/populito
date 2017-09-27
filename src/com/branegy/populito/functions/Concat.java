package com.branegy.populito.functions;

import java.util.List;

import com.branegy.populito.Function;
import com.branegy.populito.SharedState;
import com.branegy.populito.formatter.FormattableFunction;

public class Concat extends Function {
    List<Function> functions;

    public Concat() {
    }
    
    public void setList(Function list ) {
        functions = ((ListFunction)list).getValues();
    }

    @Override
    public void setState(SharedState state) {
        super.setState(state);
        for (Function f : functions) {
            f.setState(state);
        }
    }

    @Override
    public Object nextValue() {
        int length = functions.size();
        Object[] values = new Object[length];
        boolean _long = true;
        long result = 0;
        for (int i=0;i<length;i++) {
            Function function = functions.get(i);
            values[i] =  function.nextValue();
            if (function instanceof FormattableFunction) {
                values[i] = ((FormattableFunction)function).formatValue(values[i]);
            }
            _long = _long && (values[i] instanceof Long);
            if (_long) {
                result +=  (Long)values[i];
            }
        }
        if (!_long) {
            StringBuffer sb = new StringBuffer();
            for (int i=0;i<values.length;i++) {
                sb.append(values[i]);
            }
            return sb.toString();
        }
        return result;
    }


}
