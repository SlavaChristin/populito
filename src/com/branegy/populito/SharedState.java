package com.branegy.populito;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.branegy.populito.formatter.Formatter;

public class SharedState {
    public final Random rnd;
    
    public Object[] values;
    
    private List<FieldInfo> fields;
    
    private Map<String, Connection> connections = new HashMap<String, Connection>();
    
    private Connection defaultConnection = null;

    private SharedState parentState;
    
    protected Formatter formatter;

    SharedState() {
        this(System.currentTimeMillis());
    }

    SharedState(long seed) {
        rnd = new Random(seed);
    }

    public List<FieldInfo> getFields() {
        return fields;
    }

    public void setFields(List<FieldInfo> fields) {
        this.fields = fields;
    }

    public int getFieldIndex(String fieldName) {
        for (int i = 0; i < fields.size(); i++) {
            if (fields.get(i).name.equals(fieldName)) {
                return i;
            }
        }
        throw new RuntimeException("No such field " + fieldName);
    }
    
    public Object getFieldValue(String fieldName) {
        int size = fields.size();
        for (int i = 0; i < size; i++) {
            if (fields.get(i).name.equals(fieldName)) {
                return values[i];
            }
        }
        throw new RuntimeException("No such field " + fieldName);
    }

    public void addConnection(String connectionName, Connection connection) {
        connections.put(connectionName, connection);
    }

    protected void setDefaultConnection(Connection connection) {
        defaultConnection = connection;
    }

    public Connection getConnection(String connectionName) throws Exception {
        return connections.get(connectionName);
    }
    
    public Connection getDefaultConnection() {
        if (defaultConnection==null) {
            throw new RuntimeException("Default connection was not set");
        }
        return defaultConnection;
    }

    public void setParentState(SharedState state) {
        parentState = state;
    }
    
    public SharedState getParentState() {
        return parentState;
    }

    public void reset() {
        for (FieldInfo f : fields) {
            f.generator.reset();
        }
    }

}
