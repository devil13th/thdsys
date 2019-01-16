package com.thd.codegen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.thd.codegen.CodeGenColumnConfig;


public abstract class JdbcUtilImpl implements JdbcUtil {
	//数据库链接地址
	// mysql      "jdbc:mysql://localhost:3306/jdbctest";
	// sqlserver  "jdbc:jtds:sqlserver://10.0.10.184:1433/zbdsmisdb"
	// oracle     "jdbc:oracle:thin:@10.0.10.195:1521:dsmis"
	protected String url = "jdbc:mysql://localhost:3306/jdbctest";
	
	protected String schema = "thd";
	//数据库用户名
	protected String uname = "root";
	//数据库密码
	protected String upwd = "123456";
	//数据库链接对象
	protected Connection conn;
	//数据库类型 oracle mysql sqlserver
	protected String dbtype; 
	//驱动类
	// oracle "oracle.jdbc.driver.OracleDriver"
	// mysql "com.mysql.jdbc.Driver" 或 "org.gjt.mm.mysql.Driver"
	// sqlserver "net.sourceforge.jtds.jdbc.Driver"
	protected String driver = "com.mysql.jdbc.Driver";
	
	
	public Logger log = Logger.getLogger(this.getClass());
	
	protected Map<String,String> dBTypeMap = new HashMap<String,String>();
	
	protected JdbcUtilImpl(){
		/*this.mysqlDBTypeMap.put("int", "java.lang.Integer");
		this.mysqlDBTypeMap.put("varchar", "java.lang.String");
		this.mysqlDBTypeMap.put("date", "java.util.Date");
		this.mysqlDBTypeMap.put("decimal", "java.lang.Double");
		this.mysqlDBTypeMap.put("float", "java.lang.Float");
		this.mysqlDBTypeMap.put("double", "java.lang.Double");
		this.mysqlDBTypeMap.put("datetime", "java.util.Date");
		
		this.oracleDBTypeMap.put("clob", "java.lang.String");
		this.oracleDBTypeMap.put("date", "java.util.Date");
		this.oracleDBTypeMap.put("number", "java.lang.Double");
		this.oracleDBTypeMap.put("varchar2", "java.lang.String");
		*/
	}
	
	
	
	
	protected JdbcUtilImpl(String uname,String upwd,String url,String schema){
		this.uname = uname;
		this.upwd = upwd;
		this.url = url;
		this.schema = schema;
		//驱动是在子类的构造方法中进行设置的
		/*
		if(dbType.toUpperCase().equals("MYSQL")){
			this.driver = "com.mysql.jdbc.Driver";
		}else if(dbType.toUpperCase().equals("ORACLE")){
			this.driver = "oracle.jdbc.driver.OracleDriver";
		}else if(dbType.toUpperCase().equals("SQLSERVER")){
			this.driver = "net.sourceforge.jtds.jdbc.Driver";
		}
		*/
	}
	/**
	 * 打开数据库链接
	 * @throws Exception
	 */
	protected void openConn() throws Exception{
		try{
			Class.forName(this.driver);
			conn = DriverManager.getConnection(url, uname,upwd);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * 关闭数据库链接
	 * @throws Exception
	 */
	protected void closeConn() throws Exception{
		try{
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public abstract List<CodeGenColumnConfig> loadColumnCfg(String dbTableName) throws Exception;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}




	public String getSchema() {
		return schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	};
	
	
	
	
}
