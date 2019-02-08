package com.thd.common.infrastructure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thd.core.dao.JdbcDao;
import com.thd.utils.myutils.bean.QueryDicBean;
@Service
public class CommonServiceImpl implements CommonService {
	@Autowired
	private JdbcDao jdbcDao;
	@Override
	public List querySelectDataSource(QueryDicBean qdb) {
		List l = this.jdbcDao.query(qdb.markSql(null));
		return l;
	}

}
