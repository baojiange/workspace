package com.core.web.ssm.util;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.stereotype.Service;

import com.core.web.ssm.bean.BatchtaskDefine;
import com.core.web.ssm.job.QuartzJob;



/**
 * 
 *
 * 定时任务的工具类
 * @author wangxw
 *
 */

@Service
public class ScheduleUtil {

	
	
	/**
     * 获取触发器key
     * 
     * @param jobName
     * @param jobGroup
     * @return
     */
    public static TriggerKey getTriggerKey(String jobName, String jobGroup) {

        return TriggerKey.triggerKey(jobName, jobGroup);
    }
    
    
    /**
     * 获取jobKey
     *
     * @param jobName the job name
     * @param jobGroup the job group
     * @return the job key
     */
    public static JobKey getJobKey(String jobName, String jobGroup) {

        return JobKey.jobKey(jobName, jobGroup);
    }
	
	
	
	/**
	 * 添加任务
	 * @param scheduler
	 * @param scheduleJob
	 * @param jobClass
	 * @throws Exception
	 */
	public static void addJob(Scheduler scheduler,BatchtaskDefine scheduleJob,Class<? extends Job> jobClass)throws Exception{
		/*addJob(scheduler,scheduleJob.getTaskName(), scheduleJob.getTaskGroup(),
	            scheduleJob.getCronExpression(),jobClass, scheduleJob);*/
		scheduleJob.setUrl("www.baidu.com");
		dynamicAddJob(scheduler,scheduleJob.getTaskName(), scheduleJob.getTaskGroup(),
	            scheduleJob.getCronExpression(), scheduleJob);
		
	}
	
	public static void dynamicAddJob(Scheduler scheduler,String jobName, String jobGroup,
            String cronExpression, Object param)throws Exception{
		// 构建job信息
		JobDetail jobDetail = JobBuilder.newJob(QuartzJob.class)
				.withIdentity(jobName, jobGroup).build();

		// 放入需要的参数,等到运行时可以通过方法获取该参数
		jobDetail.getJobDataMap().put("jobParam", param);

		// 表达式调度构建器(即任务执行的时间)
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
				.cronSchedule(cronExpression);

		// 按新的cronExpression表达式构建一个新的trigger
		CronTrigger trigger = TriggerBuilder.newTrigger()
				.withIdentity(jobName, jobGroup).withSchedule(scheduleBuilder)
				.build();

		try {
			scheduler.scheduleJob(jobDetail, trigger);

		} catch (SchedulerException e) {
			System.out.println("创建定时任务失败" + e);
			throw new Exception("创建定时任务失败");
		}
	}
	
	
	public static void addJob(Scheduler scheduler,String jobName, String jobGroup,
            String cronExpression, Class<? extends Job> jobClass, Object param)throws Exception{
		
		//构建job信息
		JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroup).build();
		
		//放入需要的参数,等到运行时可以通过方法获取该参数
		jobDetail.getJobDataMap().put("jobParam", param);
		
		//表达式调度构建器(即任务执行的时间)
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

        //按新的cronExpression表达式构建一个新的trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName, jobGroup)
            .withSchedule(scheduleBuilder).build();
        
        try {
        	scheduler.scheduleJob(jobDetail, trigger);
            
        } catch (SchedulerException e) {
            System.out.println("创建定时任务失败"+e);
            throw new Exception("创建定时任务失败");
        }
	}
	
	/**
	 * 删除定时任务
	 * @param scheduler
	 * @param jobName
	 * @param jobGroup
	 * @throws Exception
	 */
	public static void deleteJob(Scheduler scheduler, String jobName, String jobGroup)throws Exception{
		try{
			//删除定时任务时   先暂停任务，然后再删除
			JobKey jobKey = getJobKey(jobName, jobGroup);
			scheduler.pauseJob(jobKey);
			scheduler.deleteJob(jobKey);
		}catch(Exception e){
			System.out.println("删除定时任务失败"+e);
			throw new Exception("删除定时任务失败");
		}
	}
	
	/**
	 * 更新定时任务
	 * @param scheduler
	 * @param scheduleJob
	 * @throws Exception
	 */
	public static void updateJob(Scheduler scheduler, BatchtaskDefine scheduleJob)throws Exception{
		updateJob(scheduler, scheduleJob.getTaskName(), 
				scheduleJob.getTaskGroup(), scheduleJob.getCronExpression(), scheduleJob);
	}
	
	
	
	public static void updateJob(Scheduler scheduler, String jobName,
			String jobGroup, String cronExpression, Object param)throws Exception {

		try {
			TriggerKey triggerKey =getTriggerKey(jobName,jobGroup);
			// 表达式调度构建器
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

			// 按新的cronExpression表达式重新构建trigger
			trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

			// 按新的trigger重新设置job执行
			scheduler.rescheduleJob(triggerKey, trigger);
		} catch (SchedulerException e) {
			System.out.println("更新定时任务失败"+e);
			throw new Exception("更新定时任务失败");
		}
	}
	
	/**
	 * 暂停定时任务
	 * @param scheduler
	 * @param jobName
	 * @param jobGroup
	 * @throws Exception
	 */
	public static void pauseJob(Scheduler scheduler, String jobName, String jobGroup) throws Exception {
		
		JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
        try {
            scheduler.pauseJob(jobKey);
        } catch (SchedulerException e) {
            System.out.println("暂停定时任务失败"+e);
            throw new Exception("暂停定时任务失败");
        }
	}
	
	/**
	 * 恢复任务
	 * @param scheduler
	 * @param jobName
	 * @param jobGroup
	 * @throws Exception
	 */
	public static void resumeJob(Scheduler scheduler, String jobName, String jobGroup) throws Exception {
		
        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
        try {
            scheduler.resumeJob(jobKey);
        } catch (SchedulerException e) {
            System.out.println("恢复定时任务失败"+e);
            throw new Exception("恢复定时任务失败");
        }
	}
	
	/**
     * 运行一次任务
     * 
     * @param scheduler
     * @param jobName
     * @param jobGroup
     * @throws Exception 
     */
    public static void runOnce(Scheduler scheduler, String jobName, String jobGroup) throws Exception {
        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
        try {
            scheduler.triggerJob(jobKey);
        } catch (SchedulerException e) {
           System.out.println("运行任务失败"+e);
            throw new Exception("运行一次定时任务失败");
        }
    }
	
}
