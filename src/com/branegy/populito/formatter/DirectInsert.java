package com.branegy.populito.formatter;

import java.io.FileNotFoundException;
// import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
// import java.util.Date;
import java.util.List;

import com.branegy.populito.FieldInfo;
import com.branegy.populito.Populito;
import com.branegy.populito.PopulitoConfig;
import com.branegy.populito.SharedState;
// import com.microsoft.sqlserver.jdbc.SQLServerBulkCopy;
// import com.microsoft.sqlserver.jdbc.SQLServerBulkCopyOptions;  


public class DirectInsert implements Formatter {
	Connection conn;
	PreparedStatement ps;
	int line = 0;
	int column = 1;
	String tableName;

    public DirectInsert(Connection connection) {
        super(); 
        this.conn = connection;
    }
    
    @Override
    public void initialize(PopulitoConfig cfg, SharedState state) throws FileNotFoundException,
            UnsupportedEncodingException {
    	
    	StringBuilder build = new StringBuilder("insert into ["+cfg.tableName+"] (");
   	 	List<FieldInfo> fields = state.fields;
        int fieldNumber = fields.size();
        this.tableName = cfg.tableName;
        boolean first = true;
        for (int j = 0; j < fieldNumber; j++) {
            if (fields.get(j).produceOutput) {
            	if (first) {
            		first = false;
            	} else { 
            		build.append(",");
            	}
            	
                build.append("[").append(fields.get(j).name).append("]");
            }
        }
        build.append(") values (");
        first = true;
        for (int j = 0; j < fieldNumber; j++) {
            if (fields.get(j).produceOutput) {
            	if (first) {
            		first = false;
            	} else { 
            		build.append(","); 
            	}

            	build.append("?");
            }
        }
        build.append(");");
        try {
	        conn.setAutoCommit(false);
	        ps = conn.prepareStatement(build.toString());         
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
        line = 0;
    	 
    	/*
		  SQLServerBulkCopyOptions options = new SQLServerBulkCopyOptions();
		  options.setBatchSize(500);
		  options.setBulkCopyTimeout(30);
		  options.setCheckConstraints(false);
		  options.setFireTriggers(true);
		  // options.setKeepIdentity(false);
		  // options.setKeepNulls(false);
		  options.setTableLock(true);
		  // options.setUseInternalTransaction(false);
		  
    	
    	SQLServerBulkCopy bulkCopy =  new SQLServerBulkCopy(conn);
    	bulkCopy.setDestinationTableName(cfg.tableName);
    	
    	bulkCopy.writeToServer(arg0);
    	
        List<FieldInfo> fields = state.fields;
        int fieldNumber = fields.size();
        for (int j = 0; j < fieldNumber; j++) {
            if (fields.get(j).produceOutput) {
                if (prefix.length() > 0) {
                    prefix += ',';
                }
                prefix += fields.get(j).name;
            }
        }
        */
    }

    @Override
    public void startRow() {
    	line++;
    	column = 1;
    	System.out.println(tableName+" line "+line);
    }

    @Override
    public void endRow() {
    	try {
    	       ps.addBatch();
    	} catch (Exception e) {
    		throw new RuntimeException(e);
    	}
    }

    @Override
    public void newField(String name, Object value, Object formattedValue) {
    	//if (value==null) {
    	//	ps.setNull(parameterIndex, sqlType);
    	//}
    	if (Populito.DEBUG) {
        	System.out.println("    "+name+"                               :".substring(0,30-name.length())+": "+formattedValue);
    	}
    	try {
	    	ps.setObject(column, value);
	    	column++;
    	} catch (Exception e) {
    		throw new RuntimeException(e);
    	}

/*
    	ps.setNu
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
*/
    }
    
    

    @Override
    public void commit() {
    	try {
	    	ps.executeBatch();
			conn.commit();
    	} catch (Exception e) {
    		throw new RuntimeException(e);
    	}
    }
    
    public void close() {
    	try {
	    	ps.close();
    	} catch (Exception e) {
    		throw new RuntimeException(e);
    	}    	
    }
}
