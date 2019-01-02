package com.thd.core.thread;

import java.util.Map;

public class ThreadLocalContextHolder {
	private static final ThreadLocal<Map> context = new ThreadLocal<Map>();
	

	private static final ThreadLocal<String> threadLocalname = new ThreadLocal<String>();
	
	
	public static void setContext(Map paramMap){
		context.set(paramMap);
    }
	
	public static Map getContext(){
		return context.get();
    }
	
	
	public static void setName(String name){
		threadLocalname.set(name);
    }
	
	public static String getName(){
		return threadLocalname.get();
    }
	
	
	
}
