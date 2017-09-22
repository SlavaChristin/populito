package com.branegy.populito.formatter;

import com.branegy.populito.PopulitoConfig;
import com.branegy.populito.SharedState;

public interface Formatter {
	
    void initialize(PopulitoConfig config, SharedState state) throws Exception;

    void newField(String fieldName, Object value, Object formattedValue);

    void startRow();

    void endRow();

    void commit();
    
    void close();
}
