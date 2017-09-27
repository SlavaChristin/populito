package com.branegy.populito.functions;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.branegy.populito.Function;
import com.branegy.populito.formatter.FormattableFunction;

public class Now extends Function implements FormattableFunction {

    Date staticDate;
    SimpleDateFormat formatter;
    boolean useFirstValue;

    @Override
    public Object nextValue() {
        Date result;
        if (useFirstValue) {
            if (staticDate==null) {
                staticDate = new Date();
            }
            result = staticDate;
        } else {
            result = new Date();
        }
        return result;
    }

    public void setSingleton(String singleton) {
        useFirstValue = singleton.equalsIgnoreCase("true");
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
