package com.core.web.ssm.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.core.web.ssm.bean.User;
import com.core.web.ssm.dao.UserMapper;
import com.core.web.ssm.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	public static Logger log4j = org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserMapper userDao;
	
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	public List<User> getUserList() {
		
		return userDao.getUserList();
	}

	public int insert(User user) {
		int result = userDao.insert(user);
		return result;
	}

	public int delete(int id) {
		int result = userDao.delete(id);
		return result;
	}

	public int update(User user) {
		int result = userDao.update(user);
		return result;
	}

	public int userInsert(User user) throws Exception {
		int i = userDao.insert(user);
		return i;
	}

	public void insertUser(User user) throws Exception {
		int min = user.getMinNumber();
		int max = user.getMaxNumber();
		
		for(int i =min;i<=max;i++){
			User users = new User();
			users.setAge(user.getAge());
			users.setDeptment(user.getDeptment());
			users.setUserName(String.valueOf(i));
			userDao.insert(users);
		}
		int m =0;
		m=m/0;
		
	}

	@Override
	public void getAllUser() {
		List<User> list = userDao.getUserList();
		String result = JSON.toJSONString(list);
		log4j.info("列表===================================="+result);
	}

	

}
