package com.thd.webtest.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thd.core.dao.JdbcDao;
import com.thd.utils.myutils.MyListUtils;
@Service
public class WebTestServiceImpl implements WebTestService {
	@Autowired
	private JdbcDao jdbcDaoImpl;
	
	@Transactional
	public void testDbLock(){
		String sql = "select * from person where id = '1' for update";
		List<Map<String,Object>> l = this.jdbcDaoImpl.query(sql);
		if(MyListUtils.isNotEmpty(l)){
			Map<String,Object> m = l.get(0);
			Integer age = Integer.valueOf(m.get("age").toString());
			age++;
			String sqlUpdate = "update person set age = " + age + " where id = '1'";
			int i = this.jdbcDaoImpl.execute(sqlUpdate);
			System.out.println(i);
		}
		
		
		
	};
}
