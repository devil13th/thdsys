package com.thd.utils.myutils.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryBean {
	//倒序
	public static String DESC = "DESC";
	//正序
	public static String ASD = "ASC";
	
	//排序规则 desc asc
	private String sortOrder;
	//排序列
	private String sortColumn;
	//总条目数
	private Integer total;
	//每页条目数
	private Integer pageSize;
	//当前第几页
	private Integer current;
	//总页数
	private Integer maxPage;
	//查询条件(Map)
	private Map<String,String> conditions;
	//sql语句
	private String sql;
	//sql占位参数
	private List sqlParams ;
		
	//查询结果
	private List result;
	
	
	public QueryBean(){
		
	}
	

	
	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getSortColumn() {
		return sortColumn;
	}

	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrent() {
		return current;
	}

	public void setCurrent(Integer current) {
		this.current = current;
	}

	public Map<String, String> getConditions() {
		if(this.conditions == null){
			this.conditions = new HashMap<String,String>();
		}
		return conditions;
	}

	public void setConditions(Map<String, String> conditions) {
		this.conditions = conditions;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public List getSqlParams() {
		if(this.sqlParams == null){
			sqlParams = new ArrayList();
		}
		return sqlParams;
	}

	public void setSqlParams(List sqlParams) {
		this.sqlParams = sqlParams;
	}

	public List getResult() {
		return result;
	}

	public void setResult(List result) {
		this.result = result;
	}

	public Integer getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}
	
	
	
	
}
