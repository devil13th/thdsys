/** 
 * Class Description:########
 * Date : 2017年7月1日 上午9:55:10
 * Auth : wanglei 
*/  

package com.thd.utils.myutils;

import static org.quartz.TriggerBuilder.newTrigger;

import java.util.Date;
import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.Trigger.TriggerState;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

public class MyTimerUtils {
	private SchedulerFactory schedulerFactory;
	private Scheduler scheduler;
	private static  MyTimerUtils myTimerUtils;
	public static MyTimerUtils getInstance() throws Exception{
		if(myTimerUtils == null){
			myTimerUtils = createInstance();
		}
		return myTimerUtils;
	}
	
	private static MyTimerUtils createInstance() throws Exception{
		myTimerUtils = new MyTimerUtils();
		myTimerUtils.schedulerFactory = new StdSchedulerFactory();
		myTimerUtils.scheduler = myTimerUtils.schedulerFactory.getScheduler();
		return myTimerUtils;
	}
	
	//添加定时任务 plan = "0/1 * * * * ?" 1秒执行一次
	public void addTimer(String jobId,String jobGroup,Class<? extends Job> jobClass,String plan) throws Exception{
		System.out.println(jobId+"|" + jobGroup + "|" + jobClass + "|" + plan);
		CronTrigger trigger = newTrigger().withIdentity(jobId, jobGroup).withSchedule(CronScheduleBuilder.cronSchedule(plan)).build();
		//TriggerKey triggerKey = TriggerKey.triggerKey("task_1", "group_1");
		JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobId, jobGroup).build();
		scheduler.scheduleJob(jobDetail, trigger);
	}
	
	//某个任务运行一次
	public void runOneTime(String jobId,String jobGroup) throws Exception{
		JobKey t_jobKey = JobKey.jobKey(jobId, jobGroup);
		scheduler.triggerJob(t_jobKey);
	}
	
	//开启所有定时任务
	public void startAllJob() throws Exception{
		scheduler.start();
	}
	
	
	//停止某个定时任务
	public void pauseJob(String jobId,String jobGroup) throws Exception{
		JobKey jobKey = JobKey.jobKey(jobId,jobGroup);
		scheduler.pauseJob(jobKey);
	}
	
	//运行某个定时任务
	public void startJob(String jobId,String jobGroup) throws Exception{
		JobKey r_jobKey = JobKey.jobKey(jobId, jobGroup);
		scheduler.resumeJob(r_jobKey);
	}
	
	//删除某个定时任务
	public void deleteJob(String jobId,String jobGroup) throws Exception{
		//删除任务
		JobKey d_jobKey = JobKey.jobKey(jobId, jobGroup);
		scheduler.deleteJob(d_jobKey);
	}
	
	//更新任务执行时间
	public void updateJob(String jobId,String jobGroup,String plan) throws Exception{
		JobKey r_jobKey = JobKey.jobKey(jobId, jobGroup);
		scheduler.pauseJob(r_jobKey);
		// trigger已存在，则更新相应的定时设置   plan = "0/3 * * * * ?" -- 每三秒执行一次
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(plan);
		TriggerKey triggerKey = TriggerKey.triggerKey(jobId,jobGroup);
		CronTrigger trigger = (CronTrigger)scheduler.getTrigger(triggerKey);
		// 按新的cronExpression表达式重新构建trigger
		trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
		// 按新的trigger重新设置job执行
		scheduler.rescheduleJob(triggerKey, trigger);
		//查看运行状态
		System.out.println("运行状态：" + scheduler.getTriggerState(triggerKey));
	}
	
	
	public void queryJob() throws Exception{
		//查询定时任务
		System.out.println("查询定时任务");
		System.out.println("------------------------------------------");
		for(String groupName : scheduler.getJobGroupNames()) {
			for(Object obj : scheduler.getJobKeys(GroupMatcher.groupEquals(groupName))) {
				JobKey jobKey = (JobKey)obj;
				String jobName = jobKey.getName();
				String jobGroup = jobKey.getGroup();
				JobDetail jd = scheduler.getJobDetail(jobKey);
				System.out.println("[jobName] : " + jobName + " [groupName] : "+ jobGroup );
				List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
				for(Trigger tg : triggers){
					Date nextFireTime = tg.getNextFireTime(); 
					System.out.println("    [jobName] : " + jobName + " [groupName] : "+ jobGroup + " - " + nextFireTime);
				}
			}
		}
	}
	
	
	
	
	
	
	
	//查看某个定时任务的状态
	public String getState(String jobId,String jobGroup) throws Exception{
		TriggerKey triggerKey = TriggerKey.triggerKey(jobId,jobGroup);
		TriggerState state = scheduler.getTriggerState(triggerKey);
		return state.name();
	}
	
	
	
	
	
}
