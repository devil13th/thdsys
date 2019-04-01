package com.thd.core.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
创建线程池的构造函数
public ThreadPoolExecutor(int corePoolSize,
						int maximumPoolSize,
						long keepAliveTime,
						TimeUnit unit,
						BlockingQueue<Runnable> workQueue,
						ThreadFactory threadFactory,
						RejectedExecutionHandler handler) 
参数含义如下:
corePoolSize： 线程池核心线程数
maximumPoolSize：线程池最大数
keepAliveTime： 空闲线程存活时间
unit： 时间单位
workQueue： 线程池所使用的缓冲队列
threadFactory：线程池创建线程使用的工厂
handler： 线程池对拒绝任务的处理策略

*/
public class ThreadPoolFactory {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	public static ThreadPoolExecutor executor;
	
	public ThreadPoolFactory(){
		logger.info("初始化线程池");
		/**
		 * 下例中创建的线程池为：
		 * - 参数1 线程池中核心线程2个
		 * - 参数2 线程池中最大线程个数：4个 (其中包含2个核心线程) 
		 * - 参数3 线程存活时间
		 * - 参数4 线程存货时间的单位
		 * - 参数5 线程缓冲队列
		 *   队列中可最多有2个线程排队(此数量不包含在最大线程个数中)
		 *   也就是说该线程池中最多可以容纳下6个线程
		 *   最多有4个线程同时执行，还有2个线程在排队
		 *   如果此时再进入一个线程，则会抛异常了(拒绝策略决定)
		 */
		ThreadPoolFactory.executor = new ThreadPoolExecutor(2, 4, 1000, TimeUnit.MILLISECONDS,
	            new ArrayBlockingQueue<Runnable>(2));
		
		//空闲线程超时后会销毁,即使空闲线程数小于等于核心线程数
		ThreadPoolFactory.executor.allowCoreThreadTimeOut(true);
	}
	
}
