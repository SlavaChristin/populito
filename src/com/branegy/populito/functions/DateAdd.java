package com.branegy.populito.functions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.branegy.populito.Function;
import com.branegy.populito.SharedState;
import com.branegy.populito.formatter.FormattableFunction;

public class DateAdd extends Function implements FormattableFunction {

    Function datepart;
    Function number;
    Function date;
	Calendar c = new GregorianCalendar();
    SimpleDateFormat formatter;

    @Override
    public Object nextValue() {
    	Object dateValue = date.nextValue();
    	if (dateValue == null) {
    		return null;
    	}
    	c.setTime((Date)dateValue);
    	
    	String datepartV = toString(datepart.nextValue());
    	int field = -1;
    	if (datepartV.equals("day")) {
    		field = Calendar.DAY_OF_MONTH;
    	} else {
    		throw new RuntimeException("Only day is not supported as a datepart");
    	}
    	
    	int amount = (int)toLong(number.nextValue());
    	c.add(field, amount);
    	return c.getTime();
    }

    @Override
    public void setState(SharedState state) {
        super.setState(state);
        if (datepart!=null) datepart.setState(state);
        if (number!=null) number.setState(state);
        if (date!=null) date.setState(state);
    }
    
    

    @Override
	public void setSeed(long seed) {
		super.setSeed(seed);
        if (datepart!=null) datepart.setSeed(seed);
        if (number!=null) number.setSeed(seed);
        if (date!=null) date.setSeed(seed);
	}


    @Override
    public String formatValue(Object value) {
        return value==null ? null : formatter.format((Date)value);
    }

    public void setFormat(Function format) {
        String pattern = toString(format.nextValue());
        formatter = new SimpleDateFormat(pattern);
    }

	public void setDatepart(Function datepart) {
		this.datepart = datepart;
	}

	public void setNumber(Function number) {
		this.number = number;
	}

	public void setDate(Function date) {
		this.date = date;
	}

}
