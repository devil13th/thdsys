package com.thd.base.test.webconfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.thd.base.test.interceptor.LogInterceptor;
import com.thd.core.filter.TimeFilter;
@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
	private LogInterceptor loginterceptor;
	
	/**
	 * 拦截器的配置
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginterceptor);
		//对某些地址进行拦截某些路径不拦截
		registry.addInterceptor(loginterceptor).addPathPatterns("/**").excludePathPatterns("/static/**");
		//WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	
	

}
