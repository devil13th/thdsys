package com.thd.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController {
	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
}
