package com.thd.codegen;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成器字段配置
 * @author ThirdteenDevil
 *
 */
public class CodeGenColumnConfig {
	//字段CODE
	private String columnCode;
	//字段名称
	private String columnName;
	//字段类型
	private String columnType;
	//数据库字段类型
	private String columnDataType;
	//字段长度
	private Integer columnDataLength;
	//是否主键
	private Boolean isPk = false;
	//字段备注
	private String columnDesc;
	
	
	//---------------内部使用
	//字段名属性
	private String columnCodeForProperty;
	//字段名类名
	private String columnCodeForClass;
	//字段名大写
	private String columnCodeForUpper;
	public String getColumnCode() {
		return columnCode;
	} 
	public void setColumnCode(String columnCode) {
		this.columnCode = columnCode;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getColumnType() {
		return columnType;
	}
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	public Boolean getIsPk() {
		return isPk;
	}
	public void setIsPk(Boolean isPk) {
		this.isPk = isPk;
	}
	public String getColumnDesc() {
		return columnDesc;
	}
	public void setColumnDesc(String columnDesc) {
		this.columnDesc = columnDesc;
	}
	public String getColumnCodeForProperty() {
		return columnCodeForProperty;
	}
	public void setColumnCodeForProperty(String columnCodeForProperty) {
		this.columnCodeForProperty = columnCodeForProperty;
	}
	public String getColumnCodeForUpper() {
		return columnCodeForUpper;
	}
	public void setColumnCodeForUpper(String columnCodeForUpper) {
		this.columnCodeForUpper = columnCodeForUpper;
	}
	public String getColumnCodeForClass() {
		return columnCodeForClass;
	}
	public void setColumnCodeForClass(String columnCodeForClass) {
		this.columnCodeForClass = columnCodeForClass;
	}
	public String getColumnDataType() {
		return columnDataType;
	}
	public void setColumnDataType(String columnDataType) {
		this.columnDataType = columnDataType;
	}
	public Integer getColumnDataLength() {
		return columnDataLength;
	}
	public void setColumnDataLength(Integer columnDataLength) {
		this.columnDataLength = columnDataLength;
	}
	
}
