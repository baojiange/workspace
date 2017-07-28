package com.core.web.ssm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.quartz.Job;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.core.web.ssm.bean.BatchtaskDefine;
import com.core.web.ssm.service.BatchtaskDefineService;
import com.core.web.ssm.util.ScheduleUtil;
import com.core.web.ssm.util.WriteUtil;

@Controller
@RequestMapping("task")
public class TaskController {

	@Resource
	private BatchtaskDefineService batchtaskDefineService;
	
	
	@Resource
	private Scheduler scheduler;
	
	/**
	 * 显示任务列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/loadList")
	public ModelAndView listPage()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("task/taskList");
		List<BatchtaskDefine> batchList = batchtaskDefineService.findTaskList();
		mv.addObject("taskList",batchList);
		return mv;
	}
	
	
	@RequestMapping(value="/runOnce")
	public void run(int id,HttpServletResponse response)throws Exception{
		JSONObject json = new JSONObject();
		//通过id  查找这个任务
		BatchtaskDefine task = batchtaskDefineService.selectByPrimaryKey(Long.valueOf(id));
		ScheduleUtil.runOnce(scheduler,task.getTaskName(), task.getTaskGroup());
		json.put("success", "true");
		 WriteUtil.write(response,json.toString());
	}
	
	@RequestMapping(value="/addPage")
	public ModelAndView addPage()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("task/add");
		return mv;
	}
	
	
	@RequestMapping(value="/addTask")
	@SuppressWarnings("unchecked")
	public String add(BatchtaskDefine record)throws Exception{
		batchtaskDefineService.insert(record);
		Class<? extends Job> clazz = (Class<? extends Job>) Class.forName(record.getTaskServ());
		//ScheduleUtil.addJob(scheduler,record,clazz);
		ScheduleUtil.addJob(scheduler,record,clazz);
		return "redirect:/task/loadList";
	}
	
	
	/**
	 * 跳转到修改页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/loadEditPage")
	public ModelAndView loadEditPage(int id)throws Exception{
		ModelAndView mv = new ModelAndView();
		BatchtaskDefine record = batchtaskDefineService.selectByPrimaryKey(Long.valueOf(id));
		mv.addObject("record", record);
		mv.setViewName("task/edit");
		return mv;
	}
	
	/**
	 * 修改任务
	 * @param record
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/eidtTask")
	public String edit(BatchtaskDefine record)throws Exception{
		ScheduleUtil.updateJob(scheduler,record);
		batchtaskDefineService.updateByPrimaryKeySelective(record);
		return "redirect:/task/loadList";
	}
	
	/**
	 * 删除任务
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/delTask")
	public String delete(int id)throws Exception{
		BatchtaskDefine record = batchtaskDefineService.selectByPrimaryKey(Long.valueOf(id));
		ScheduleUtil.deleteJob(scheduler,record.getTaskName(), record.getTaskGroup());
		batchtaskDefineService.deleteByPrimaryKey(Long.valueOf(id));
		return "redirect:/task/loadList";
	}
	
	/**
	 * 暂停任务
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/pauseTask")
	public String pauseTask(int id)throws Exception{
		BatchtaskDefine record = batchtaskDefineService.selectByPrimaryKey(Long.valueOf(id));
		ScheduleUtil.pauseJob(scheduler,record.getTaskName(), record.getTaskGroup());
		return "redirect:/task/loadList";
	}
	
	/**
	 * 恢复任务
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/resumeTask")
	public String resumeTask(int id)throws Exception{
		BatchtaskDefine record = batchtaskDefineService.selectByPrimaryKey(Long.valueOf(id));
		ScheduleUtil.resumeJob(scheduler,record.getTaskName(), record.getTaskGroup());
		return "redirect:/task/loadList";
	}
	
}
