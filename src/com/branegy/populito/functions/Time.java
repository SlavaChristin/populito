package com.branegy.populito.functions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.branegy.populito.Function;
import com.branegy.populito.SharedState;
import com.branegy.populito.formatter.FormattableFunction;

public class Time extends Function implements FormattableFunction {

    Function min;
    Function max;

    SimpleDateFormat formatter;

    @Override
    public Object nextValue() {
        try {
        	Object minValue = min.nextValue();
        	Object maxValue = max.nextValue();
            long min_l = (minValue instanceof Date)? ((Date)minValue).getTime() : formatter.parse(toString(minValue)).getTime();
            long max_l = (maxValue instanceof Date)? ((Date)maxValue).getTime() : formatter.parse(toString(maxValue)).getTime();
            return new Date(min_l+(long)(rnd.nextFloat()*(max_l-min_l)));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setState(SharedState state) {
        super.setState(state);
        if (min!=null) min.setState(state);
        if (max!=null) max.setState(state);
    }

    public void setMin(Function min) {
        this.min = min;
    }

    public void setMax(Function max) {
        this.max = max;
    }

    public void setFormat(Function format) {
        String pattern = toString(format.nextValue());
        formatter = new SimpleDateFormat(pattern);
    }

    @Override
    public String formatValue(Object value) {
        return value==null ? null : formatter.format((Date)value);
    }

}
