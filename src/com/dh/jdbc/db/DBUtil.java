package com.dh.jdbc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {

    
    private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
    private static final String USER = "dh";
    private static final String PASSWORD = "1";
    private static Connection conn=null;
    static{
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            // TODO: handle exception
        }
       
    }
    
    public static Connection getConnection() {
        return conn;
    }
    /**
     * @throws Exception 
     * @param args
     * @throws
     */
//    public static void main(String[] args) throws Exception {
//        Class.forName("oracle.jdbc.driver.OracleDriver");
//        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery("select user_name,age from dh_test_jdbc");
//         while(rs.next()){
//            System.out.println(rs.getString("user_name")+","+rs.getInt("age"));
//            }
//    }

}
