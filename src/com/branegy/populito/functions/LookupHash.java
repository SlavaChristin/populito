package com.branegy.populito.functions;

import java.util.HashMap;
import java.util.Map;

public class LookupHash implements IHash {
    Map<Object, Map<String, Object>> values = new HashMap<Object, Map<String, Object>>();

    public Object getAttributeValue(Object key, String attribute) {
        Map<String, Object> map = values.get(key);
        return map == null ? null : map.get(attribute);
    }

    public void add(Object key, Map<String, Object> values) {
        this.values.put(key, values);
    }

}
