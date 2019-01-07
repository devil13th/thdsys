package com.thd.utils.myutils.bean;

import javax.servlet.http.HttpServletRequest;

public class QueryBeanForWeb extends QueryBean {
	public QueryBeanForWeb(){}
	public QueryBeanForWeb(HttpServletRequest request){
		if(request.getParameter("current") != null){
			try{
				int current = Integer.parseInt(request.getParameter("current"));
				this.setCurrent(current);
			}catch(Exception e){
				throw e;
			}
		}
		
		if(request.getParameter("pageSize") != null){
			try{
				int pageSize = Integer.parseInt(request.getParameter("pageSize"));
				this.setPageSize(pageSize);
			}catch(Exception e){
				throw e;
			}
		}
		
		this.setSortColumn(request.getParameter("sort"));
		this.setSortOrder(request.getParameter("order"));
	}
}
