package com.thd.base.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thd.core.thread.MyThread;
import com.thd.core.thread.ThreadLocalContextHolder;
import com.thd.core.thread.ThreadPoolFactory;

@Controller
@RequestMapping(path="/threadPoolTest")
public class ThreadPoolTestController {
	@RequestMapping(path="/createThread/{threadName}",method=RequestMethod.GET)
	@ResponseBody
	public String createThread(@PathVariable String threadName){
		MyThread mt = new MyThread(threadName);
		ThreadPoolFactory.executor.execute(mt);
		return threadName;
	}
	
	
	@RequestMapping(path="/threadPoolInfo",method=RequestMethod.GET)
	@ResponseBody
	public Map threadPoolInfo(){
		Map m = new HashMap();
		
		//获取 ThreadLocal 变量(设置在ThreadPoolInitFilter中)
		System.out.println(ThreadLocalContextHolder.getContext());
		System.out.println(ThreadLocalContextHolder.getName());
		m.put("CorePoolSize", ThreadPoolFactory.executor.getCorePoolSize());
		m.put("MaximumPoolSize", ThreadPoolFactory.executor.getMaximumPoolSize());
		m.put("LargestPoolSize", ThreadPoolFactory.executor.getLargestPoolSize());
		
		
		
		m.put("PoolSize", ThreadPoolFactory.executor.getPoolSize());
		m.put("ActiveCount", ThreadPoolFactory.executor.getActiveCount());
		m.put("QueueSize", ThreadPoolFactory.executor.getQueue().size());
		
		return m;
		
	}
}
