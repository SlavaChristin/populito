package com.branegy.populito.formatter;

import com.branegy.populito.PopulitoConfig;
import com.branegy.populito.SharedState;


public class ConsoleFormatter implements Formatter {
    int line = 0;
    int column = 1;
    String tableName;

    public ConsoleFormatter() {
        super();
    }
    
    @Override
    public void initialize(PopulitoConfig cfg, SharedState state) {
        tableName = cfg.tableName;
    }

    @Override
    public void startRow() {
        line++;
        column = 1;
        System.out.println(tableName+" line "+line);
    }

    @Override
    public void endRow() {
    }

    @Override
    public void newField(String name, Object value, Object formattedValue) {
        System.out.println("    "+name+"                               :".substring(0,30-name.length())+": "+formattedValue);
    }

    @Override
    public void commit() {
        System.out.flush();
    }

    @Override
    public void close() {
    }
}
