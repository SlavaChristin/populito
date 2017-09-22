package com.branegy.populito.functions;

import com.branegy.populito.Function;

public class Sequence extends Function {

    long next = 0;
    long step = 0;
    long max = Long.MAX_VALUE;
    Function start;

    public void setStart(Function start) {
        this.next = toLong(start.nextValue());
        this.start = start;
    }

    public void setStep(Function step) {
        this.step = toLong(step.nextValue());
    }

    public void setMax(Function max) {
        this.max = toLong(max.nextValue());
    }

    @Override
    public Object nextValue() {
        long result = next;
        if (result > max) {
            result = toLong(start.nextValue());
            next = result;
        }
        next += step;
        return result;
    }

	@Override
	public void reset() {
		next = toLong(start.nextValue());
	}

}
