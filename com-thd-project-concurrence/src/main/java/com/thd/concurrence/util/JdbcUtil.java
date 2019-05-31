package com.thd.concurrence.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcUtil {
	private static Connection conn;
	
	public static Connection getConn() {
		if(conn == null){
			synchronized(JdbcUtil.class){
				if(conn==null){
				    String driver = "com.mysql.cj.jdbc.Driver";
				    String url = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC&charset=utf-8";
				    String username = "root";
				    String password = "123456";
				    try {
				        Class.forName(driver); //classLoader,加载对应驱动
				        conn = (Connection) DriverManager.getConnection(url, username, password);
				    } catch (ClassNotFoundException e) {
				        e.printStackTrace();
				    } catch (SQLException e) {
				        e.printStackTrace();
				    }
				}
			}
		}
	    return conn;
	}
	
	
	
	public static Connection getNewConn() {
		
		Logger log = LoggerFactory.getLogger(JdbcUtil.class);
	    String driver = "com.mysql.cj.jdbc.Driver";
	    String url = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC&charset=utf-8";
	    String username = "root";
	    String password = "123456";
	    Connection newConn  = null;
	    try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        newConn = (Connection) DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException e) {
	    	log.info("获取连接失败,未找到" + driver);
	    } catch (SQLException e) {
	    	log.info("获取连接失败:" + e.getMessage());
	    }
	    if(newConn == null){
	    	log.info(" conn is null");
	    }
	    return newConn;
	}
	
	
	
	public static void closeConn(Connection conn){
		try{
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
