package com.thd.webtest.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter(filterName="MqInitFilter",urlPatterns="/mq")
public class MQInitFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		chain.doFilter(req,res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		//创建点对点消息发送者
		System.out.println("创建点对点消息发送者");
		
		

	}

}
