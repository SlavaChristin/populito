package com.branegy.populito.formatter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import com.branegy.populito.FieldInfo;
import com.branegy.populito.PopulitoConfig;
import com.branegy.populito.SharedState;

public class SqlInsertFormatter implements Formatter {
    PrintWriter out;
    String prefix = "";
    boolean first = true;
    String quote = "\"";
    final StringBuffer line  = new StringBuffer(4000);
    int lineNumber = 0;

   
    public SqlInsertFormatter(String outFile) throws Exception {
    	this(new PrintWriter(outFile, "UTF-8"));
	}


    public SqlInsertFormatter(PrintWriter out) {
        super();
        this.out = out;
    }
    
    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public void initialize(PopulitoConfig cfg, SharedState state) throws FileNotFoundException,
            UnsupportedEncodingException {
        List<FieldInfo> fields = state.getFields();
        int fieldNumber = fields.size();
        for (int j = 0; j < fieldNumber; j++) {
            if (fields.get(j).produceOutput) {
                if (prefix.length() > 0) {
                    prefix += ',';
                }
                prefix += fields.get(j).name;
            }
        }
        prefix = "insert into " + cfg.tableName + " (" + prefix + ") values (";
        // FileWriter wf = new FileWriter("populito.out");
        // PrintWriter out = new PrintWriter(new BufferedWriter(wf,4000000));
    }

    @Override
    public void startRow() {
        first = true;
        line.setLength(0);
    }

    @Override
    public void endRow() {
        out.print(prefix);
        out.print(line);
        out.println(");");
        line.setLength(0);
        lineNumber++;
        if (lineNumber % 100==0) {
        	out.println("GO");
        }
    }

    @Override
    public void newField(String name, Object value, Object formattedValue) {
        if (first) {
            first = false;
        } else {
            line.append(',');
        }
        if (value == null) {
            value = "null";
        } else if (value instanceof Integer || value instanceof Long || value instanceof Double) {
             value = formattedValue;
        } else if (value instanceof Date) {
            value = "TIMESTAMP "+quote+formattedValue+quote; 
        } else if (value instanceof String) {
            value = quote + value + quote;
        }
        line.append(value);

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
