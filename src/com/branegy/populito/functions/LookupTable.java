package com.branegy.populito.functions;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.branegy.populito.Function;
import com.branegy.populito.SharedState;

public class LookupTable extends Function {
    private Function query;
    private String key;
    private LookupHash table;
    private String dataSource;
    // private String database;

    @Override
    public void setState(SharedState state) {
        super.setState(state);
        query.setState(state);
    }

    @Override
    public Object nextValue() {
        if (table==null) {
            table = createTable();
        }
        return table;
    }

    private LookupHash createTable() {
        String queryStr = toString(query.nextValue());
        try {
            Statement statement = state.getConnection(dataSource).createStatement();
            ResultSet rs = statement.executeQuery(queryStr);
            ResultSetMetaData metaData = rs.getMetaData();
            int n = metaData.getColumnCount();
            LookupHash result = new LookupHash();
            while (rs.next()) {
                Object keyValue = rs.getObject(key);
                Map<String,Object> values = new HashMap<String,Object>(n);
                for (int i=1;i<=n;i++) {
                    values.put(metaData.getColumnName(i), rs.getObject(i));
                }

                result.add(keyValue,values);
            }
            statement.close();
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Cannot execute query "+queryStr,e);
        }
    }

    public void setQuery(Function query) {
        this.query = query;
    }

    public void setKey(Function key) {
        this.key = toString(key.nextValue());
    }

    public LookupHash getTable() {
        return table;
    }

    public void setDataSource(Function dataSource) {
        final String value = toString(dataSource.nextValue());
        // final String[] parts = value.split("/");
        this.dataSource = value;
        // this.database = parts[1];
    }

}
