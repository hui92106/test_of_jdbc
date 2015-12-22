package com.dh.jdbc.action;

import java.util.Date;

import com.dh.jdbc.dao.DTJTableDao;
import com.dh.jdbc.model.DTJTable;

public class DTJTableAction {
    public static void main(String[] args) throws Exception {
        DTJTableDao d = new DTJTableDao();
        DTJTable d1= new DTJTable();
        d1.setId(2);
        d1.setUser_name("12312312124312êÍ");
        d1.setAge(24);
        d1.setBirthday(new Date());
        d1.setEmail("asdf");
        d1.setMobile("");
        d1.setUpdate_user("");
        d1.setCreate_user("");
        d1.setSex(1);
        d1.setIsdel(1);
//        d.addDTJTable(d1);
//        d.delDTJTable(4);
//        d.updateDTJTable(d1);
        DTJTable d4 = d.queryDTJTable(4);
        System.out.println(d4.toString());
    }
}
