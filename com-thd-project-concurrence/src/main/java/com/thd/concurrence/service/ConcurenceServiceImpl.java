package com.thd.concurrence.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.thd.concurrence.util.JdbcUtil;
import com.thd.concurrence.util.JedisUtil;

@Service
public class ConcurenceServiceImpl implements ConcurrenceService {
	public  int xlock(int id){
		//Connection conn = JdbcUtil.getConn();
		Connection conn = JdbcUtil.getNewConn();
		String increaseSql = "update transaction_testa set age = age+1 where id = 1";
		String addSql = " insert into transaction_testb (id,school,nickname) values(?,?,?)";
		String lockSql = " select * from transaction_testa where id = 1 for update";
		
		int r = 0;
		try {
			
			conn.setAutoCommit(false);
			Statement lockPs = conn.createStatement();
			lockPs.executeQuery(lockSql);
			
			PreparedStatement ps = conn.prepareStatement(increaseSql);
			PreparedStatement addPs = conn.prepareStatement(addSql);
			addPs.setString(1,String.valueOf(UUID.randomUUID()).replace("-",""));
			addPs.setString(2, "devil13th");
			addPs.setInt(3, (int) (Math.random() * 100));
			
			r = ps.executeUpdate();
			addPs.executeUpdate();
			conn.commit();
			ps.close();
			addPs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return r;
		
	};
	
	public  int optimisticLock(int id){
		//Connection conn = JdbcUtil.getConn();
		Connection conn = JdbcUtil.getNewConn();
		String increaseSql = "update transaction_testa set age = age+1 , version = version+1 where id = 1 and version = ?";
		String addSql = " insert into transaction_testb (id,school,nickname) values(?,?,?)";
		String lockSql = " select id,name,age,version from transaction_testa where id = 1 ";
		
		int r = 0;
		try {
			
			conn.setAutoCommit(false);
			Statement lockPs = conn.createStatement();
			ResultSet rs = lockPs.executeQuery(lockSql);
			rs.next();
			int version = rs.getInt("version");
			
			
			
			
			PreparedStatement addPs = conn.prepareStatement(addSql);
			addPs.setString(1,String.valueOf(UUID.randomUUID()).replace("-",""));
			addPs.setString(2, "devil13th");
			addPs.setInt(3, (int) (Math.random() * 100));
			addPs.executeUpdate();
			
			PreparedStatement ps = conn.prepareStatement(increaseSql);
			ps.setInt(1, version);
			r = ps.executeUpdate();
			if(r != 1){
				conn.rollback();
			}
			conn.commit();
			ps.close();
			addPs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return r;
		
	};
	
	
	public long addForRedis(){
		return JedisUtil.push((int)(Math.random() * 100));
	}
	public void clearRedis(){
		JedisUtil.clearRedis();
	}
	
}
