package com.core.web.ssm.job;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.core.web.ssm.bean.BatchtaskDefine;

public class QuartzJob implements Job{

	@Override
	public void execute(JobExecutionContext context)throws JobExecutionException {
		BatchtaskDefine record = (BatchtaskDefine)context.getJobDetail().getJobDataMap().get("jobParam");
		System.out.println(new Date());
		System.out.println("业务类url:"+record.getUrl());
	}

}
