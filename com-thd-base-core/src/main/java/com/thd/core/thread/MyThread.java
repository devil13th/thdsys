package com.thd.core.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyThread implements Runnable{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private String name;
	public MyThread(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		
		logger.info(this.name + " start ...");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		logger.info(this.name + " finish ...");
	}
}
