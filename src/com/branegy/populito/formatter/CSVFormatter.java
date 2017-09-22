package com.branegy.populito.formatter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.branegy.populito.FieldInfo;
import com.branegy.populito.PopulitoConfig;
import com.branegy.populito.SharedState;

public class CSVFormatter implements Formatter {
    PrintWriter out;
    boolean first = true;
    final StringBuffer line  = new StringBuffer(4000);
    int lineNumber = 0;
    private final String outFile;
    
    public CSVFormatter(String outFile) {
    	this.outFile = outFile;		
	}

    @Override
    public void initialize(PopulitoConfig cfg, SharedState state) throws FileNotFoundException,
            UnsupportedEncodingException {
        List<FieldInfo> fields = state.fields;
        int fieldNumber = fields.size();
        String header = "";
        for (int j = 0; j < fieldNumber; j++) {
            if (fields.get(j).produceOutput) {
                if (header.length() > 0) {
                    header += ',';
                }
                header += fields.get(j).name;
            }
        }
        out = new PrintWriter(outFile, "UTF-8");
        out.println(header);
    }

    @Override
    public void startRow() {
        first = true;
    }

    @Override
    public void endRow() {
        out.println(line);
        line.setLength(0);
        lineNumber++;
    }

    @Override
    public void newField(String field, Object value, Object formattedValue) {
        if (first) {
            first = false;
        } else {
            line.append(',');
        }
        if (formattedValue == null) {
        	formattedValue = "null";
        } else if (formattedValue instanceof String) {
        	formattedValue = "\"" + formattedValue + "\"";
        }
        line.append(formattedValue);
    }

    @Override
    public void commit() {
    	out.flush();
    }

	@Override
	public void close() {
        out.close();
	}
}
