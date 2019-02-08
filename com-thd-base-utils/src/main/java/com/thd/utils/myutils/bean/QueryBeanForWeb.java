package com.thd.utils.myutils.bean;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
		
		
		//除分页信息以外的信息汇总成Map<String,String>的数据格式,暂不支持相同名称的key(后面覆盖前面)
		Enumeration<String> keys = request.getParameterNames();
		String notDealName = "current,pageSize,sortColumn,sortOrder,";
		while(keys.hasMoreElements()){
			String name = keys.nextElement();
			if(notDealName.indexOf(name) == -1){
				this.getQueryParams().put(name, request.getParameter(name));
			}
		}
	}
	
	
}
