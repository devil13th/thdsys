package com.thd.core.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadPoolFactory {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	public static ThreadPoolExecutor executor;
	
	public ThreadPoolFactory(){
		logger.info("初始化线程池");
		/**
		 * 下例中创建的线程池为：
		 * - 线程池中核心线程2个
		 * - 线程池中最大线程个数：4个 (其中包含2个核心线程)
		 * - 队列中可最多有2个线程排队(此数量不包含在最大线程个数中)
		 *   也就是说该线程池中最多可以容纳下6个线程
		 *   最多有4个线程同时执行，还有2个线程在排队
		 *   如果此时再进入一个线程，则会抛异常了(拒绝策略决定)
		 */
		ThreadPoolFactory.executor = new ThreadPoolExecutor(2, 4, 1000, TimeUnit.MILLISECONDS,
	            new ArrayBlockingQueue<Runnable>(2));
	}
	
}
