package com.dh.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dh.jdbc.db.DBUtil;
import com.dh.jdbc.model.DTJTable;

public class DTJTableDao {
    public void addDTJTable(DTJTable d) throws Exception {
        Connection conn = DBUtil.getConnection();
        String sql = "INSERT INTO DH_TEST_JDBC " +
        		"(ID,USER_NAME,SEX,AGE,BIRTHDAY,EMAIL,MOBILE,CREATE_USER,CREATE_DATE," +
        		"UPDATE_USER,UPDATE_DATE,ISDEL)" +
        		"VALUES(?,?,?,?,?,?,?,?,SYSDATE,?,SYSDATE,?"+")";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1, d.getId());
        ptmt.setString(2, d.getUser_name());
        ptmt.setInt(3, d.getSex());
        ptmt.setInt(4, d.getAge());
        ptmt.setDate(5, new Date(d.getBirthday().getTime()));
        ptmt.setString(6, d.getEmail());
        ptmt.setString(7, d.getMobile());
        ptmt.setString(8, d.getCreate_user());
//        ptmt.setDate(9, (Date) d.getCreate_date());
        ptmt.setString(9, d.getUpdate_user());
//        ptmt.setDate(10, (Date) d.getUpdate_date());
        ptmt.setInt(10, d.getIsdel());
        ptmt.execute();
    }
    public void updateDTJTable(DTJTable d) throws Exception {
        Connection conn = DBUtil.getConnection();
        String sql = "UPDATE DH_TEST_JDBC " +
                " SET USER_NAME=?,SEX=?,AGE=?,BIRTHDAY=?,EMAIL=?,MOBILE=?,UPDATE_DATE=SYSDATE,ISDEL = ?" +
                " where id = ?";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, d.getUser_name());
        ptmt.setInt(2, d.getSex());
        ptmt.setInt(3, d.getAge());
        ptmt.setDate(4, new Date(d.getBirthday().getTime()));
        ptmt.setString(5, d.getEmail());
        ptmt.setString(6, d.getMobile());
        ptmt.setInt(7, d.getIsdel());
        ptmt.setInt(8, d.getId());

        ptmt.execute();
        
    }
    public void delDTJTable(Integer i) throws Exception {
        Connection conn = DBUtil.getConnection();
        String sql = "delete from  dh_test_jdbc t  where t.id = ?";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1, i);
        ptmt.execute();
        
    }
    public List<DTJTable> query() throws Exception{
        Connection conn = DBUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT ID,USER_NAME,AGE FROM DH_TEST_JDBC");
        List<DTJTable> dt = new ArrayList<DTJTable>(); 
        DTJTable d =null;
        while(rs.next()){
            d = new DTJTable();
            d.setId(rs.getInt("id"));
            d.setUser_name(rs.getString("USER_NAME"));
            d.setAge(rs.getInt("AGE"));
            dt.add(d);
        }

        return dt;
    }
    public List<DTJTable> query(List<Map<String, Object>> parmas) throws SQLException{
        
        Connection conn = DBUtil.getConnection();
        
        StringBuilder sb = new StringBuilder();
        sb.append("select * from DH_TEST_JDBC where 1=1");
        if(parmas != null && parmas.size()>0){
            for (int i = 0; i < parmas.size(); i++) {
                Map<String, Object> map = parmas.get(i);
                sb.append(" and "+map.get("name")+" "+map.get("rela")+" " +map.get("value"));
                System.out.println(map.toString());
                System.out.println(sb.toString());
            }
        }
        
        PreparedStatement ptmt = conn.prepareStatement(sb.toString());
        ResultSet rs = ptmt.executeQuery();
        List<DTJTable> dt = new ArrayList<DTJTable>(); 

        DTJTable d = new DTJTable();
        while (rs.next()) {
            d.setId(rs.getInt("id"));
            d.setUser_name(rs.getString("user_name"));
            d.setSex(rs.getInt("sex"));
            d.setAge(rs.getInt("age"));
            d.setBirthday(rs.getDate("birthday"));
            d.setEmail(rs.getString("email"));
            d.setMobile(rs.getString("mobile"));
            d.setCreate_user(rs.getString("create_user"));
            d.setCreate_date(rs.getDate("create_date"));
            d.setUpdate_user(rs.getString("update_user"));
            d.setUpdate_date(rs.getDate("update_date"));
            d.setIsdel(rs.getInt("isdel"));
            
            dt.add(d);
        }
        System.out.println(dt.toString());
        return dt;
    }
    
    public DTJTable get(Integer id) throws Exception {
        Connection conn = DBUtil.getConnection();
        String sql = "SELECT * FROM DH_TEST_JDBC t where t.id = ?";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1, id);
        ResultSet rs = ptmt.executeQuery();
        DTJTable d = null;
        while(rs.next()){
            d = new DTJTable();
            d.setUser_name(rs.getString("USER_NAME"));
            d.setAge(rs.getInt("AGE"));
        }
        
        return d;
        
    }
    
}
