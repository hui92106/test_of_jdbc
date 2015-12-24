package com.dh.jdbc.action;

import java.util.List;
import java.util.Map;

import com.dh.jdbc.dao.DTJTableDao;
import com.dh.jdbc.model.DTJTable;

public class DTJTableAction {
    
    public void add(DTJTable dtj) throws Exception{
        DTJTableDao dtjDao = new DTJTableDao();
        dtjDao.addDTJTable(dtj);
    }
    public DTJTable  get(Integer id) throws Exception {
        DTJTableDao dtjDao = new DTJTableDao();
        return dtjDao.get(id);
    }
    public void edit(DTJTable dtj) throws Exception{
        DTJTableDao dtjDao = new DTJTableDao();
        dtjDao.updateDTJTable(dtj);
    }
    public void del(Integer id) throws Exception {
        DTJTableDao dtjDao = new DTJTableDao();
        dtjDao.delDTJTable(id);
    }
    public List<DTJTable> query() throws Exception{
        DTJTableDao dtjDao = new DTJTableDao();
        return dtjDao.query();
    }
    public List<DTJTable> queryDTJTable(List<Map<String,Object>>parmas) throws Exception {
        DTJTableDao dtjDao = new DTJTableDao();
        return dtjDao.query(parmas);
    }
}
