package com.thd.common.infrastructure.service;

import java.util.List;

import com.thd.utils.myutils.bean.QueryDicBean;

public interface CommonService {
	/**
	 * 查询字典信息
	 * @param qdb
	 * @return
	 */
	public List querySelectDataSource(QueryDicBean qdb);
}
