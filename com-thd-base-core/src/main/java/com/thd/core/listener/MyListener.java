package com.thd.core.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyListener implements HttpSessionListener {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		logger.info("MyListener sessionCreated-----");
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
    	logger.info("MyListener sessionDestroyed-----");
    }

}
