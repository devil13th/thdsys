package com.thd.base.test.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 定时任务
 * @author wangl
 *
 */
@Service
public class ScheduleService {
	Logger log = LoggerFactory.getLogger(this.getClass());
	//@Scheduled(cron="0 * * * * *")
	public void hello(){
		log.info("hello");
	};
}
