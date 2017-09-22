package com.branegy.populito.functions;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.branegy.populito.Function;

public class MD5 extends Function {
    String value;
    Function data;

    public void setData(Function data) {
        this.data = data;
    }

    @Override
    public Object nextValue() {
        if (value == null || !(data instanceof Constant)) {
            MessageDigest md;
            try {
                md = MessageDigest.getInstance("MD5");
                value = toString(data.nextValue());
                md.update(value.getBytes());
                byte[] hash = md.digest();
                StringBuffer hexString = new StringBuffer();

                for (int i = 0; i < hash.length; i++) {
                    if ((0xff & hash[i]) < 0x10) {
                        hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
                    } else {
                        hexString.append(Integer.toHexString(0xFF & hash[i]));
                    }
                }
                value = hexString.toString();
            } catch (NoSuchAlgorithmException e) {
                // TODO Auto-generated catch block
                throw new RuntimeException(e);
            }
        }

        return value;
    }

}
