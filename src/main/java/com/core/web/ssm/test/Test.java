package com.core.web.ssm.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext(
				new String[] {
						"classpath*:spring-mvc.xml","classpath*:spring-mybatis.xml",
						"classpath*:spring.xml"});  
	   QuartzTest quartzTest=context.getBean("quartzTest",QuartzTest.class);  
	   quartzTest.startSchedule();  
	   try {
		//quartzTest.start();
		System.out.println("1111");
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	}
}
