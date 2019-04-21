package com.thd.core.dao;

import java.util.List;
import java.util.Map;

import com.thd.core.bean.Page;
import com.thd.utils.myutils.bean.QueryBean;


public interface JdbcDao {
	/**
	 * 带有占位符的分页查询
	 * @param sql sql语句
	 * @param params 占位符数据
	 * @param currentPage 当前页
	 * @param pageSize 每页显示条目数
	 * @return
	 */
	public List<Map<String,Object>> query(String sql,Object[] params,Integer currentPage ,Integer pageSize);
	/**
	 * 带有占位符的分页查询
	 * @param sql sql语句
	 * @param params 占位符数据
	 * @param p 分页信息,最终查询出来的总条目数会设置在p.total属性中
	 * @return
	 */
	public List<Map<String,Object>> query(String sql,Object[] params,Page p);
	/**
	 * 直接执行sql查询语句
	 * @param sql 查询语句
	 * @return
	 */
	public List<Map<String,Object>> query(String sql);
	/**
	 * 查询总条目数
	 * @param sql 查询语句
	 * @param params 占位符的值
	 * @return
	 */
	public int queryCount(String sql,Object[] params);
	/**
	 * 场景查询
	 * 查询结果也封装到QueryBean类中
	 * @param queryBean 封装了查询语句,排序,查询条件,分页信息内容
	 * @see com.thd.utils.myutils.bean.QueryBean
	 */
	public void query(QueryBean queryBean);
	
	public int execute(String sql);
}
