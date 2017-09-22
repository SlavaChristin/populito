package com.branegy.populito.functions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.branegy.populito.Function;
import com.branegy.populito.SharedState;

/* Returns random record from database */
public class LookupRecord extends Function  {
    private Function query;

    private String dataSource;
    private List<LookupItem> list;
    private String attribute;

    public static class LookupItem extends HashMap<String,Object> implements IHash {
        private static final long serialVersionUID = -7755453952529250627L;

        public LookupItem(int n) {
            super(n);
        }

        @Override
        public Object getAttributeValue(Object key, String attribute) {
            return get(attribute);
        }
    }

    @Override
    public void setState(SharedState state) {
        super.setState(state);
        query.setState(state);
    }

    @Override
    public Object nextValue() {
        List<LookupItem> options = getList();
        if (options.isEmpty()) {
            throw new RuntimeException("List is empty. No data to pick from");
        }
        int index = (int)(rnd.nextFloat()*(options.size()-1));
        LookupItem lookupItem = options.get(index);
		return attribute==null ? lookupItem : lookupItem.get(attribute);
    }
    
    public void setAttribute(String attribute) {
    	this.attribute = attribute;
    }

    private List<LookupItem> buildList() {
        String queryStr = toString(query.nextValue());
        try {
            Connection connection = state.getConnection(dataSource);
            if (connection==null || connection.isClosed()) {
            	throw new RuntimeException("Connection "+dataSource+" does not exist or closed");
            }
			Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(queryStr);
            ResultSetMetaData metaData = rs.getMetaData();
            int n = metaData.getColumnCount();
            List<LookupItem> result = new ArrayList<LookupItem>();
            while (rs.next()) {
                LookupItem item = new LookupItem(n);
                for (int i=1;i<=n;i++) {
                    item.put(metaData.getColumnName(i), rs.getObject(i));
                }

                result.add(item);
            }
            statement.close();
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Cannot execute query "+queryStr, e);
        }
    }

    public void setQuery(Function query) {
        this.query = query;
    }

    public List<LookupItem> getList() {
        if (list==null) {
            list = buildList();
        }
        return list;
    }

    public void setDataSource(Function dataSource) {
        final String value = toString(dataSource.nextValue());
        this.dataSource = value;
    }

}
