package com.thd.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
@Order(2)
//重点
@WebFilter(filterName = "TimeFilter", urlPatterns = "/a")
public class TimeFilter implements Filter {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void destroy() {
		logger.info("destroy " + this.getClass().getName() + " ... ");

	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
			throws IOException, ServletException {
		
		long beginTime = System.currentTimeMillis();
		
		logger.info("*********************************" + this.getClass().getName() + " start **************************");
		chain.doFilter(req, res);
		logger.info("*********************************" + this.getClass().getName() + " end **************************");
		logger.info(" 总执行时间:" +  (System.currentTimeMillis() - beginTime));
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		logger.info("load " + this.getClass().getName() + " ... ");
	}
	
	/**
	 * 1.在主配置类上添加注释@ServletComponentScan
	 * 2.在Filter类上添加注释@WebFilter(filterName = "TimeFilter", urlPatterns = "/*")
	 * 3.编写Filter内容
	 */

}
