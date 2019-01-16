package com.thd.codegen;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.thd.codegen.jdbc.JdbcUtil;
import com.thd.codegen.jdbc.OracleJdbcUtilImpl;

public class JdbcUtilTest extends TestCase {
	@Test
	public void testloadColumnCfg() throws Exception{
		//数据库链接地址
		String url = "jdbc:oracle:thin:@172.26.200.100:1521:oradb";
		//数据库用户名
		String uname = "dsmis";
		//数据库密码
		String upwd = "dsmis123456";
		//数据库类型
		String dbtype = "oracle";
		JdbcUtil ju = new OracleJdbcUtilImpl(uname,upwd,url,"thd");
		List l = ju.loadColumnCfg("work_survey_list");
		System.out.println(l);
	}
}
