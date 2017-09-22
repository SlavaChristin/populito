package com.branegy.populito.functions;

import com.branegy.populito.Function;

public class Email extends Function {

    //?:[a-z0-9!#$%&'*+/=?^_`{|}~
    char chars[] = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM01234567890.".toCharArray();
    StringBuffer sb = new StringBuffer(20);

    @Override
    public Object nextValue() {
        int len = 5+(int)(rnd.nextFloat()*6);
        sb.setLength(0);
        for (int i=0;i<len;i++) {
            int name = rnd.nextInt(chars.length);
            sb.append(chars[name]);
        }
        sb.append("@branegy.com");
        return sb.toString();
    }

}
