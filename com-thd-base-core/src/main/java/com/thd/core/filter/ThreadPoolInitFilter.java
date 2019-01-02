package com.thd.core.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thd.core.thread.ThreadLocalContextHolder;
import com.thd.core.thread.ThreadPoolFactory;
public class ThreadPoolInitFilter implements Filter {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info( " filter init ");
		new ThreadPoolFactory();
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		logger.info("filter...");
		
		//测试ThreadLocal
		Map m = new HashMap();
		m.put("name", "devil13th");
		ThreadLocalContextHolder.setContext(m);
		ThreadLocalContextHolder.setName("devil13th");
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
