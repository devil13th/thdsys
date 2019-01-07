package com.thd.core.dao;

import java.util.List;
import java.util.Map;

import com.thd.core.bean.Page;
import com.thd.utils.myutils.bean.QueryBean;


public interface JdbcDao {
	public List<Map<String,Object>> query(String sql,Object[] params,Integer currentPage ,Integer pageSize);
	public List<Map<String,Object>> query(String sql,Object[] params,Page p);
	public int queryCount(String sql,Object[] params);
	public void query(QueryBean queryBean);
}
