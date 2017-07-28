package com.core.web.ssm.bean;

import java.util.Date;

public class User {

	private int id;
	private String userName;
	private int age;
	private String deptment;
	
	private Date createDate;
	
	//测试批量插入到数据库是否回滚
	private int minNumber;
	private int maxNumber;
	
	public int getMinNumber() {
		return minNumber;
	}
	public void setMinNumber(int minNumber) {
		this.minNumber = minNumber;
	}
	public int getMaxNumber() {
		return maxNumber;
	}
	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDeptment() {
		return deptment;
	}
	public void setDeptment(String deptment) {
		this.deptment = deptment;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
