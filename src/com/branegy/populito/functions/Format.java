package com.branegy.populito.functions;

import java.text.DecimalFormat;

import com.branegy.populito.Function;
import com.branegy.populito.SharedState;
import com.branegy.populito.formatter.FormattableFunction;

public class Format extends Function implements FormattableFunction {
    Function value;
    String pattern;
    DecimalFormat formatter;

    @Override
    public void setState(SharedState state) {
        super.setState(state);
        value.setState(state);
        formatter = new DecimalFormat(pattern);
    }

    public void setValue(Function value) {
        this.value = value;
    }

    public void setPattern(Function pattern) {
        this.pattern = toString(pattern.nextValue());
    }

    @Override
    public Object nextValue() {
        return value.nextValue();
    }

    @Override
    public String formatValue(Object value) {
        return formatter.format(value);
    }

}
