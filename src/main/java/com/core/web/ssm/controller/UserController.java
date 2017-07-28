package com.core.web.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.core.web.ssm.bean.User;
import com.core.web.ssm.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	/*
	 * 这里声明一下，这里有三种写法：Model model,ModelMap modelMap,ModelAndView mv
	 * 可以去了解一下他们之间的区别：
	 * 个人理解是    ModelAndView  是需要自己去声明使用   
	 * 而另外两个是直接使用，不需要自己声明
	 */
	
	//获取User的信息
	@RequestMapping(value="/findUserInfo")
	public String findUserInfo(Model model,int id){
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "user/view";
	}
	
	//跳转到增加用户
	@RequestMapping(value="/addUserforward")
	public String forAddUser(){
		return "user/insert";
	}
	
	//增加用户的信息
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String insertUser(User user){
		userService.insert(user);
		return "redirect:/user/list";
	}
	
	//获取用户列表
	@RequestMapping(value="/list")
	public String findUserList(Model model){
		List<User> userList = userService.getUserList();
		model.addAttribute("userList", userList);
		return "user/list";
	}
	
	//删除用户
	@RequestMapping(value="/delete")
	public String deleteUser(int id){
		userService.delete(id);
		return"redirect:/user/list";
	}
	
	//跳转到更新
	@RequestMapping(value="/updFoward")
	public String updateForward(Model model,int id){
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return"user/update";
	}
	
	//更新用户
	@RequestMapping(value="/updateUser",method=RequestMethod.POST)
	public String updateU(User user){
		userService.update(user);
		return"redirect:/user/list";
	}
	
	//跳转到验证aop
	@RequestMapping(value="/frowardsomeUser")
	public String moreUser(){
		return "user/someInsert";
	}
	
	//aop验证增加用户
	@RequestMapping(value="/insertUser",method=RequestMethod.POST)
	public String insertSomeUser(User user){
		try{
			userService.userInsert(user);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("系统异常");
		}
		return "redirect:/user/list";
	}
	
	//跳转到批量用户页面
	@RequestMapping(value="/forwardMoreUser")
	public String moreUserForward(){
		return "user/moreUser";
	}
	
	//增加批量用户
	@RequestMapping(value="/addMoreUser",method=RequestMethod.POST)
	public String moreUserIns(User user){
		try{
			userService.insertUser(user);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("批量用户出错");
		}
		
		return "redirect:/user/list";
	}
	
}
