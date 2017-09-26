package com.branegy.populito.functions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.branegy.populito.Function;
import com.branegy.populito.SharedState;
import com.branegy.populito.formatter.FormattableFunction;

public class Time extends Function implements FormattableFunction {

    Function min;
    Function max;
    Function year;
    Function month;
    Function day;
    Function hour;
    Function minutes;
    Function seconds;

    SimpleDateFormat formatter;

    @Override
    public Object nextValue() {
        try {
            if (min!=null & max!=null) {
                Object minValue = min.nextValue();
                Object maxValue = max.nextValue();
                long min_l = (minValue instanceof Date)? ((Date)minValue).getTime() : formatter.parse(toString(minValue)).getTime();
                long max_l = (maxValue instanceof Date)? ((Date)maxValue).getTime() : formatter.parse(toString(maxValue)).getTime();
                return new Date(min_l+(long)(rnd.nextFloat()*(max_l-min_l)));
            } else {
                GregorianCalendar c = new GregorianCalendar(0, 0, 0, 0, 0, 0);
                 if (year!=null) {
                    c.set(Calendar.YEAR, (int)toLong(year.nextValue()));
                }
                if (month!=null) {
                    c.set(Calendar.MONTH, (int)toLong(month.nextValue())-1);
                }
                if (day!=null) {
                    c.set(Calendar.DAY_OF_MONTH, (int)toLong(day.nextValue()));
                }
                if (hour!=null) {
                    c.set(Calendar.HOUR_OF_DAY, (int)toLong(hour.nextValue()));
                }
                if (minutes!=null) {
                    c.set(Calendar.MINUTE, (int)toLong(minutes.nextValue()));
                }
                if (seconds!=null) {
                    c.set(Calendar.SECOND, (int)toLong(seconds.nextValue()));
                }
                return c.getTime();
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setState(SharedState state) {
        super.setState(state);
        if (min!=null) min.setState(state);
        if (max!=null) max.setState(state);
        if (year!=null) year.setState(state);
        if (month!=null) month.setState(state);
        if (day!=null) day.setState(state);
        if (hour!=null) hour.setState(state);
        if (minutes!=null) minutes.setState(state);
        if (seconds!=null) seconds.setState(state);
    }
    
    

    @Override
    public void setSeed(long seed) {
        super.setSeed(seed);
        if (min!=null) min.setSeed(seed);
        if (max!=null) max.setSeed(seed);
        if (year!=null) year.setSeed(seed);
        if (month!=null) month.setSeed(seed);
        if (day!=null) day.setSeed(seed);
        if (hour!=null) hour.setSeed(seed);
        if (minutes!=null) minutes.setSeed(seed);
        if (seconds!=null) seconds.setSeed(seed);
    }

    public void setMin(Function min) {
        this.min = min;
    }

    public void setMax(Function max) {
        this.max = max;
    }

    public void setYear(Function year) {
        this.year = year;
    }

    public void setMonth(Function month) {
        this.month = month;
    }

    public void setDay(Function day) {
        this.day = day;
    }

    public void setHour(Function hour) {
        this.hour = hour;
    }

    public void setMinute(Function minutes) {
        this.minutes = minutes;
    }

    public void setSecond(Function seconds) {
        this.seconds = seconds;
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
