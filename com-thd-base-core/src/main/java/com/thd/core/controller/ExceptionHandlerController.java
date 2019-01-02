package com.thd.core.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.thd.core.bean.ResponseBean;
/**
 * 异常处理器
 */
@RestControllerAdvice
public class ExceptionHandlerController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	/**
	 * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		logger.info("请求有参数才进来");
	}
	
	/**
	 * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
	 */
	@ModelAttribute
	public void addAttributes(Model model) {
		logger.info("author", "devil13th");
	}
	
	
	//凡是抛异常的都会被拦截
	@ExceptionHandler(Exception.class)
	public Object handleException(Exception e,HttpServletRequest req){
		logger.info(" 错误已被被拦截 ,错误信息如下 ");
		e.printStackTrace();
		ResponseBean rb = new ResponseBean();
		Map<String,String> m = new HashMap<String,String>();
		m.put("status","failure");
		m.put("message",e.getMessage());
		
		
		rb.setE(e);
		rb.setResult(m);
		rb.setHttpStatus(HttpStatus.CREATED);
		
		
		
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("status", "failure");
		//使用HttpServletRequest中的header检测请求是否为ajax, 如果是ajax则返回json, 如果为非ajax则返回view(即ModelAndView)
		String contentTypeHeader = req.getHeader("Content-Type");
		String acceptHeader = req.getHeader("Accept");
		String xRequestedWith = req.getHeader("X-Requested-With");
		return rb.failure();
		/*
		if ((contentTypeHeader != null && contentTypeHeader.contains("application/json"))
				|| (acceptHeader != null && acceptHeader.contains("application/json"))
				|| "XMLHttpRequest".equalsIgnoreCase(xRequestedWith)) {
			return rb.failure();
		} else {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("msg", e.getMessage());
			modelAndView.addObject("url", req.getRequestURL());
			modelAndView.addObject("stackTrace", e.getStackTrace());
			modelAndView.setViewName("error");
			return modelAndView;
		}*/
	}
	
}
