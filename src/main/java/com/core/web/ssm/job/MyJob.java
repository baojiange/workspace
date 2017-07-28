package com.core.web.ssm.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.core.web.ssm.bean.BatchtaskDefine;
import com.core.web.ssm.bean.BatchtaskList;
import com.core.web.ssm.bean.User;
import com.core.web.ssm.service.BatchtaskListService;
import com.core.web.ssm.service.UserService;
import com.core.web.ssm.util.SpringContextHolder;

public class MyJob implements Job {

	Logger logger = Logger.getLogger(MyJob.class);
	
	/*ClassPathXmlApplicationContext contexts =new ClassPathXmlApplicationContext("spring.xml");
	UserService userService = (UserService)contexts.getBean("userService");
	BatchtaskListService batchtaskListService =(BatchtaskListService)contexts.getBean("batchtaskListService");*/
	
	UserService userService = (UserService)SpringContextHolder.getBean("userService");
	BatchtaskListService batchtaskListService =(BatchtaskListService)SpringContextHolder.getBean("batchtaskListService");
	
	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		//System.out.println("---------------定时任务启动-------------------");
		//System.out.println("--- 用户任务: 批量任务执行开始..............");
		logger.info("---------------定时任务启动-------------------");
		logger.info("--- 用户任务: 批量任务执行开始..............");
		BatchtaskList task = new BatchtaskList();
		String runBatchDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		task.setRunBatchDate(runBatchDate);
		task.setRunBeginDate(new Date());
		task.setRunDesc("测试跑批：插入用户信息");
		task.setRunStartMode("01");
		task.setRunStatus("00");
		User user = new User();
		user.setUserName("王晓炜");
		user.setAge(102);
		user.setDeptment("僵尸部");
		user.setCreateDate(new Date());
		userService.insert(user);
		task.setRunEndDate(new Date());
		batchtaskListService.insert(task);
		logger.info("--- 用户任务: 批量任务执行结束..............");
		//System.out.println("--- 用户任务: 批量任务执行结束..............");
	       JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
	        BatchtaskDefine scheduleJob = (BatchtaskDefine) mergedJobDataMap.get("jobParam");
	        //System.out.println("jobName:" + scheduleJob.getTaskName() + "  "+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").format(new Date())+"对象:" + scheduleJob);
	        logger.info("------------定时任务结束----------------------");
	        //System.out.println("------------定时任务结束----------------------");

	}

}
