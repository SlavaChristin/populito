package com.branegy.populito.functions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.branegy.populito.Function;
import com.branegy.populito.SharedState;

public class ListFromDatabase extends ListFunction  {
    private Function query;
    private String dataSource;
    
    public void setQuery(Function query) {
        this.query = query;
    }
    
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    public void setState(SharedState state) {
        super.setState(state);
        setValues(buildList());
    }

    private List<Function> buildList() {
        String queryStr = toString(query.nextValue());
        try {
            
            Connection connection;
            if (dataSource!=null) {
                connection = state.getConnection(dataSource);
            } else {
                connection = state.getDefaultConnection();
            }
            if (connection==null || connection.isClosed()) {
                throw new RuntimeException("Connection "+dataSource+" does not exist or closed");
            }
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(queryStr);
            List<Function> result = new ArrayList<Function>();
            int columnCount = rs.getMetaData().getColumnCount();
            
            while (rs.next()) {
                if (columnCount==1) {
                    result.add(new Constant(rs.getObject(1)));
                } else {
                    Map<String, Object> tuple = new HashMap<String,Object>(columnCount);
                    for (int i=1;i<=columnCount;i++) {
                        Object value = rs.getObject(i);
                        tuple.put(rs.getMetaData().getColumnName(i), value);
                    }
                    result.add(new Constant(tuple));
                }
            }
            statement.close();
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Cannot execute query "+queryStr, e);
        }
    }

}
