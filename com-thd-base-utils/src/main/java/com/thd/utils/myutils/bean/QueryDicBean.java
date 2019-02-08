package com.thd.utils.myutils.bean;

import java.util.Map;

import com.thd.utils.myutils.MyStringUtils;

public class QueryDicBean {
	private String tableName;
	private String keyColumn;
	private String valueColumn;
	private String kw;
	
	
	public QueryDicBean(String kw,String tableName, String keyColumn, String valueColumn) {
		super();
		this.kw = kw;
		this.tableName = tableName;
		this.keyColumn = keyColumn;
		this.valueColumn = valueColumn;
	}

	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getKeyColumn() {
		return keyColumn;
	}
	public void setKeyColumn(String keyColumn) {
		this.keyColumn = keyColumn;
	}
	public String getValueColumn() {
		return valueColumn;
	}
	public void setValueColumn(String valueColumn) {
		this.valueColumn = valueColumn;
	}


	public String getKw() {
		return kw;
	}

	public void setKw(String kw) {
		this.kw = kw;
	}

	public String markSql(Map<String,String> m){
		String sql = " select distinct " 
				+ this.keyColumn + " as k ," 
				+ this.valueColumn + " as v "
				+ " from " 
				+ this.tableName 
				+ " where 1=1 ";
		
		if(MyStringUtils.isNotEmpty(this.kw)){
			sql += " and upper(" + this.valueColumn + ") like '%" + this.kw.toUpperCase().trim() + "%'";
		}
		return sql;
				
	}
	
}
