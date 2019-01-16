package com.thd.codegen;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 生成器总配置 
 * @author ThirdteenDevil
 *
 */
public class CodeGenConfig {
	
	//表英文名
	private String tableCode;
	//表中文名
	private String tableName;
	//action 所在包位置
	private String actionPackage;
	//action 名称
	private String actionName;
	//service 所在包位置
	private String servicePackage;
	//service 名称
	private String serviceName;
	//dao所在包位置
	private String daoPackage;
	//pojo 包所在位置
	private String pojoPackage;

	//jsp页面路径
	private String jspPath;
	//struts2配置的nameSpace
	private String nameSpace;
	//struts2配置的action标签的name属性
	private String urlActionName;
	//主键生成策略
	private String generator;
	//主键字段配置
	private CodeGenColumnConfig pkColumn ;
	//非主键字段配置
	private List<CodeGenColumnConfig> columnList = new ArrayList<CodeGenColumnConfig>();
	
	
	
	
	//-----------内部使用属性
	
	//表类名
	private String tableCodeForClass;
	//表实例化对象名称
	private String tableCodeForProperty;
	//表名全大写
	private String tableCodeForUpper;
	//service实例化对象名称
	private String serviceNameForProperty;
	//action实例化对象名称
	private String actionNameForProperty;
		
	
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
 
	public String getActionPackage() {
		return actionPackage;
	}

	public void setActionPackage(String actionPackage) {
		this.actionPackage = actionPackage;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getServicePackage() {
		return servicePackage;
	}

	public void setServicePackage(String servicePackage) {
		this.servicePackage = servicePackage;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getPojoPackage() {
		return pojoPackage;
	}

	public void setPojoPackage(String pojoPackage) {
		this.pojoPackage = pojoPackage;
	}

	public String getGenerator() {
		return generator;
	}

	public void setGenerator(String generator) {
		this.generator = generator;
	}

	public List<CodeGenColumnConfig> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<CodeGenColumnConfig> columnList) {
		this.columnList = columnList;
	}
	
	public String toString(){
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		return gson.toJson(this);
	}


	public CodeGenColumnConfig getPkColumn() {
		return pkColumn;
	}

	public void setPkColumn(CodeGenColumnConfig pkColumn) {
		this.pkColumn = pkColumn;
	}


	public String getTableCode() {
		return tableCode;
	}

	public void setTableCode(String tableCode) {
		this.tableCode = tableCode; 
	}

	public String getTableCodeForClass() {
		return tableCodeForClass;
	}

	public void setTableCodeForClass(String tableCodeForClass) {
		this.tableCodeForClass = tableCodeForClass;
	}

	public String getTableCodeForProperty() {
		return tableCodeForProperty;
	}

	public void setTableCodeForProperty(String tableCodeForProperty) {
		this.tableCodeForProperty = tableCodeForProperty;
	}

	public String getTableCodeForUpper() {
		return tableCodeForUpper;
	}

	public void setTableCodeForUpper(String tableCodeForUpper) {
		this.tableCodeForUpper = tableCodeForUpper;
	}

	public String getServiceNameForProperty() {
		return serviceNameForProperty;
	}

	public void setServiceNameForProperty(String serviceNameForProperty) {
		this.serviceNameForProperty = serviceNameForProperty;
	}

	public String getActionNameForProperty() {
		return actionNameForProperty;
	}

	public void setActionNameForProperty(String actionNameForProperty) {
		this.actionNameForProperty = actionNameForProperty;
	}

	public String getJspPath() {
		return jspPath;
	}

	public void setJspPath(String jspPath) {
		this.jspPath = jspPath;
	}

	public String getNameSpace() {
		return nameSpace;
	}

	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}

	public String getUrlActionName() {
		return urlActionName;
	}

	public void setUrlActionName(String urlActionName) {
		this.urlActionName = urlActionName;
	}

	public String getDaoPackage() {
		return daoPackage;
	}

	public void setDaoPackage(String daoPackage) {
		this.daoPackage = daoPackage;
	}
	
	
}
