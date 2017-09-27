package com.branegy.populito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTools {
    
    public static void cleanupTable(Connection conn, String tableName) throws Exception {
        cleanupTable(conn, tableName, null);
    }

    public static void cleanupTable(Connection conn, String tableName, String filter) throws Exception {
        String query = "delete from [" + tableName + "]" + (filter == null ? "" : " where "+filter);
        int rows = runQuery(conn, query);
        System.out.println("Removed "+rows +" row(s) from " + tableName);
    }

    public static int runQuery(Connection conn, String query) throws Exception {
        Statement stmt = conn.createStatement();
        int rows = stmt.executeUpdate(query);
        stmt.close();
        return rows;
    }

    public static void findMissingFields(Populito populito, Connection c, String tableName) throws Exception {
        List<FieldInfo> configFields = new ArrayList<FieldInfo>( populito.getFields() );
        
        PreparedStatement p = c.prepareStatement("select c.name,t.name as type, c.is_nullable "
                + " from sys.columns c join sys.types t on c.system_type_id = t.user_type_id"
                + " where object_id = object_id(?)"
                + " order by c.column_id");
        
        p.setString(1, tableName);
        ResultSet rs = p.executeQuery();
        while (rs.next()) {
            String column = rs.getString(1);
            String type   = rs.getString(2);
            boolean nullable = rs.getBoolean(3);
            
            boolean found = false;
            for (int i=0;i<configFields.size();i++) {
                if (configFields.get(i).name.equalsIgnoreCase(column)) {
                    System.out.println("Column "+column+"("+type+") found in config");
                    found = true;
                    configFields.remove(i);                    
                }
            }
            
            if (!found) {
                if (type.equals("timestamp")) {
                    System.out.println("Column "+column+"("+type+")"+ (nullable ? "" : " NOT ")+" NULL - NOT FOUND in config. Filled on Server");
                } else {
                    System.err.println("Column "+column+"("+type+")"+ (nullable ? "" : " NOT ")+" NULL - NOT FOUND in config");
                }
            }
        }
    }

}
