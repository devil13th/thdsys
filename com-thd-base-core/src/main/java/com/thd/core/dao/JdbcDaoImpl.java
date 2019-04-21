package com.thd.core.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.thd.core.bean.Page;
import com.thd.utils.myutils.bean.QueryBean;
@Repository
public class JdbcDaoImpl implements JdbcDao{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<Map<String,Object>> query(String sql,Object[] params,Integer currentPage ,Integer pageSize){
		if(currentPage !=null && pageSize != null && pageSize.compareTo(0)!=0 ){
			if(currentPage > 0){
				sql += " limit " + ((currentPage-1)*pageSize) + "," + pageSize ;
			}else{
				sql += " limit 0," + pageSize ;
			}
			
		}
		return this.jdbcTemplate.queryForList(sql, params);
	}
	
	public List<Map<String,Object>> query(String sql,Object[] params,Page p){
		logger.info("execute query SQL : " + sql);
		logger.info("execute query SQL PARAMS : " );
		if(params!=null){
			for(Object obj : params ){
				System.out.println(obj);
			}
		}
		if(p!= null && p.getCurrentPage() > 0 && p.getPageSize() > 0){
			p.setListSize(this.queryCount(sql, params));
			return this.query(sql, params,p.getCurrentPage(),p.getPageSize());
		}else{
			return this.query(sql, params,null,null);
		}
	}
	
	public List<Map<String,Object>> query(String sql){
		logger.info("execute query SQL : " + sql);
		return this.query(sql, null,null,null);
	}
	
	public int queryCount(String sql,Object[] params){
		String ctSql = "select count(1) as ct from (" + sql + ") as result";
		System.out.println("[" + this.getClass().getName() + "] execute queryCount() : " + ctSql);
		System.out.println("[" + this.getClass().getName() + "] execute query SQL PARAMS : " + ctSql);
		if(params!=null){
			for(Object obj : params ){
				System.out.println(obj);
			}
		}
		Map r = this.jdbcTemplate.queryForMap(ctSql,params);
		return Integer.parseInt(r.get("ct").toString());
	}
	
	public void query(QueryBean queryBean){
		Page p = null;
		boolean hasPageInfo = 
				queryBean.getCurrent() != null && 
				queryBean.getCurrent() > 0 && 
				queryBean.getPageSize() != null && 
				queryBean.getPageSize() > 0;
				
				
				
		if(hasPageInfo){
			p = new Page();
			p.setCurrentPage(queryBean.getCurrent());
			p.setPageSize(queryBean.getPageSize());
		}
		List l = this.query(
				queryBean.getSql(), 
				queryBean.getSqlParams() == null ? null : queryBean.getSqlParams().toArray(), 
				p);
		if(hasPageInfo){
			queryBean.setMaxPage(p.getMaxPage());
			queryBean.setTotal(p.getListSize());
		}
		queryBean.setResult(l);
		
	};
	
	public int execute(String sql){
		return this.jdbcTemplate.update(sql);
	};
}
