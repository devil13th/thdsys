package com.thd.base.test.aop;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Around("execution(* com.thd.base.test.controller.*Controller.*(..))")
	public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("----进入AOP切片 time aspect start----");
		Object[] args = pjp.getArgs();
		for (Object arg : args) {
			logger.info("arg is "+arg);
		}
		long start = new Date().getTime();
		Object object = pjp.proceed();
		logger.info("time aspect 耗时:"+ (new Date().getTime() - start));
		logger.info("----退出AOP切片 time aspect end----");
		return object;
	}

/**
 * 
注：SpringBoot 中添加切片步骤：
1.添加AOP依赖(否则项目启动的时候不会进行aop扫描)
 
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>

2.切面加入@Aspect @Component注释

3.写切面

 * 
 */
}


