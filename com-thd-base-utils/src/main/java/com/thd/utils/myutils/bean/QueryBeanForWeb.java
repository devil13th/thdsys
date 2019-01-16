package com.thd.utils.myutils.bean;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.google.gson.Gson;
/**
 * 
 * @author devil13th
 *
 */
public class QueryBeanForWeb extends QueryBean {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	public QueryBeanForWeb(){}
	/**
	 * 构造函数可自动获取request的排序及分页信息以及查询条件信息
	 * @param request
	 */
	public QueryBeanForWeb(HttpServletRequest request){
		
		
		Gson gson = new Gson();
		
		
		//如果存在queryBean字符串
		if(request.getParameter("queryBean") != null){
			try{
				QueryBean qb = gson.fromJson(request.getParameter("queryBean"),QueryBean.class);
				BeanUtils.copyProperties(qb, this);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
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
		if(request.getParameter("sortColumn") != null){
			this.setSortColumn(request.getParameter("sortColumn"));
		}
		if(request.getParameter("sortOrder") != null){
			this.setSortOrder(request.getParameter("sortOrder"));
		}
		
		if(request.getParameter("queryParams") != null){
			
			try{
				Map queryParams = gson.fromJson(request.getParameter("queryParams"), Map.class);
				this.setQueryParams(queryParams);
			}catch(Exception e){
				logger.error(" json format err ! ... ");
			}
		}
	}
	
	
}
