package com.branegy.populito;

import java.util.Set;


public class FieldInfo {

    public String name;
    public Function generator;
    public Set<String> dependencies;
    public String generatorExpression;
    public boolean produceOutput = true;
    public boolean key = false;
    public float nullPercentage = -1;

    /**
     * Possible options
     *    transient:true
     *    key: boolean -- TODO What is KEY ? 
     *    nulls:float - percentage of nulls
     */
    public void setOptions(String options) {
        if (options==null) {
            return;
        }
        for (String optionPair : options.split(",")) {
            String[] split = optionPair.split("=");
            if (split[0].trim().equalsIgnoreCase("transient")) {
                produceOutput = !"true".equalsIgnoreCase(split[1]);
            } else if (split[0].trim().equalsIgnoreCase("key")) {
                key = "true".equalsIgnoreCase(split[1]);
            } else if (split[0].trim().equalsIgnoreCase("nulls")) {
                nullPercentage =  Float.parseFloat(split[1]) / (100.0f);
            }
        }
    }

}