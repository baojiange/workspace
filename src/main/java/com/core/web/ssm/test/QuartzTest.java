package com.core.web.ssm.test;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.stereotype.Component;

import com.core.web.ssm.bean.BatchtaskDefine;
import com.core.web.ssm.job.MyJob;
import com.core.web.ssm.util.ScheduleUtil;

@Component
public class QuartzTest {

	@Resource
	private Scheduler scheduler;

	/**
	 * 开始一个simpleSchedule()调度
	 */
	public void startSchedule() {
		try {
			// 1、创建一个JobDetail实例，指定Quartz
			JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
			// 任务执行类
					.withIdentity("job1_1", "jGroup1")
					// 任务名，任务组
					.build();
			// 2、创建Trigger
			SimpleScheduleBuilder builder = SimpleScheduleBuilder
					.simpleSchedule()
					// 设置执行次数
					;
			Trigger trigger = TriggerBuilder.newTrigger()
					.withIdentity("trigger1_1", "tGroup1").startNow()
					.withSchedule(builder).build();
			// 3、创建Scheduler
			scheduler.start();
			// 4、调度执行
			scheduler.scheduleJob(jobDetail, trigger);
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			scheduler.shutdown();

		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 从数据库中找到已经存在的job，并重新开户调度
	 */
	public void resumeJob() {
		try {
			// ①获取调度器中所有的触发器组
			List<String> triggerGroups = scheduler.getTriggerGroupNames();
			// ②重新恢复在tgroup1组中，名为trigger1_1触发器的运行
			for (int i = 0; i < triggerGroups.size(); i++) {
				List<String> triggers = scheduler.getTriggerGroupNames();
				for (int j = 0; j < triggers.size(); j++) {
					Trigger tg = scheduler.getTrigger(new TriggerKey(triggers
							.get(j), triggerGroups.get(i)));
					// ②-1:根据名称判断
					if (tg instanceof SimpleTrigger
							&& tg.getDescription().equals("tgroup1.trigger1_1")) {
						// ②-1:恢复运行
						scheduler.resumeJob(new JobKey(triggers.get(j),
								triggerGroups.get(i)));
					}
				}

			}
			scheduler.start();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	
	public void start()throws Exception{
		BatchtaskDefine scheduleJob = new BatchtaskDefine();
		scheduleJob.setCreateDate(new Date());
		scheduleJob.setCronExpression("0/5 * * * * ?");
		scheduleJob.setTaskGroup("0001");
		scheduleJob.setTaskName("0001跑批");
		ScheduleUtil.addJob(scheduler,scheduleJob, MyJob.class);
	}
	
}
