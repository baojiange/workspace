package com.core.web.ssm.dao;

import java.util.List;

import com.core.web.ssm.bean.User;

public interface UserMapper {

	public User getUserById(int id);
	
	public List<User> getUserList();
	
	public int insert(User user);
	
	public int delete(int id);
	
	public int update(User user);
}
