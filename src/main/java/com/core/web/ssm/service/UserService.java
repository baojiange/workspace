package com.core.web.ssm.service;

import java.util.List;

import com.core.web.ssm.bean.User;

public interface UserService {

	public User getUserById(int id);
	
	public List<User> getUserList();
	
	public int insert(User user);
	
	public int delete(int id);
	
	public int update(User user);
	
	/**
	 * 测试aop是否控制事务
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int userInsert(User user)throws Exception;
	
	/**
	 * 测试批量插入user是否回滚
	 * @param user
	 * @throws Exception
	 */
	public void insertUser(User user)throws Exception;
	
	
	
	/**
	 * 定时任务测试
	 */
	public void getAllUser();
		
	
}
