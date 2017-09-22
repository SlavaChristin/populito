package com.branegy.populito.formatter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;

import com.branegy.populito.FieldInfo;
import com.branegy.populito.PopulitoConfig;
import com.branegy.populito.SharedState;

public class SqlUpdateFormatter implements Formatter {
    PrintWriter out;
    String prefix = "";
    final StringBuffer where = new StringBuffer();
    final StringBuffer line  = new StringBuffer();

    Set<String> keyFields = new HashSet<String>();
    boolean first = true;
    public final static char SEP = '\'';

    private final String outFile;
    
    public SqlUpdateFormatter(String outFile) {
    	this.outFile = outFile;		
	}

    @Override
    public void initialize(PopulitoConfig cfg, SharedState state) throws FileNotFoundException,
            UnsupportedEncodingException {
        prefix = "update " + cfg.tableName + " set ";
        out = new PrintWriter(outFile, "UTF-8");
        for (FieldInfo field : state.getFields()) {
            if (field.key) {
                keyFields.add(field.name);
            }
        }
    }

    @Override
    public void startRow() {
        first = true;
    }

    @Override
    public void endRow() {
        out.print(prefix);
        out.print(line);
        out.print(" where  ");
        out.print(where);
        out.println(";");

        line.setLength(0);        
        where.setLength(0);
    }

    @Override
    public void newField(String fieldName, Object value, Object formattedValue) {
        if (keyFields.contains(fieldName)) {
            if (where.length() > 0) {
                where.append(" and ");
            }
            where.append(fieldName);
            where.append("=");
            if (value == null) {
                where.append("null");
            } else if (value instanceof String) {
                where.append(SEP).append(value).append(SEP);
            } else {
                where.append(value);
            }
        } else {
            if (first) {
                first = false;
            } else {
                line.append(",");
            }
            line.append(fieldName);
            line.append("=");
            if (value == null) {
                value = "null";
            } else if (value instanceof String) {
                value = "" + SEP + value + SEP;
            }
            line.append(value);
        }
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
