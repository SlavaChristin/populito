package com.branegy.populito.functions;

import com.branegy.populito.Function;
import com.branegy.populito.SharedState;

public class IfNull extends Function {

    Function _if;
    Function _then; 
    Function _else;

    @Override
    public void setState(SharedState state) {
        _if.setState(state);
        _then.setState(state);
        _else.setState(state);

    }

    @Override
    public Object nextValue() {
        return _if.nextValue() ==null
            ? (_then ==null ? null : _then.nextValue())
            : (_else ==null ? null : _else.nextValue());
    }

    public void setIf(Function _if) {
        this._if = _if;
    }

    public void setThen(Function _then) {
        this._then = _then;
    }

    public void setElse(Function _else) {
        this._else = _else;
    }

}
