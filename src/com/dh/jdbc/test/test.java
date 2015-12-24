package com.dh.jdbc.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dh.jdbc.action.DTJTableAction;
import com.dh.jdbc.model.DTJTable;

public class test {

    /**
     * @throws Exception 
     * @param args
     * @throws
     */
    public static void main(String[] args) throws Exception {
        DTJTableAction action = new DTJTableAction();
        DTJTable d = new DTJTable();
        d.setId(1);
        d.setUser_name("adfsafd ");
        d.setSex(1);
        d.setAge(2);
        d.setEmail("123");
        d.setMobile("asdfasd");
        d.setCreate_user("asd");
        d.setUpdate_user("123");
        d.setIsdel(0);
        d.setBirthday(new java.util.Date());
//        action.add(d);
//        action.edit(d);
//        action.del(4);
        /*≤È—Ø */
//        List<DTJTable> result = action.query();
//        for (int i = 0; i < result.size(); i++) {
//            System.out.println(result.get(i).getId() +" –’√˚£∫  "+result.get(i).getUser_name());
//        }
        
        List<Map<String, Object>> params = new ArrayList<Map<String,Object>>();
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name","user_name");
        map.put("rela","=");
        map.put("value", "'12312312ÍÕ'");
        params.add(map);
        List<DTJTable> result = action.queryDTJTable(params);
        for (int i = 0; i < result.size(); i++) {
          System.out.println(result.get(i).getId() +" –’√˚£∫  "+result.get(i).getUser_name());
        }
    }

}
