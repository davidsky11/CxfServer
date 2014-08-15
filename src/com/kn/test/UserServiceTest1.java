package com.kn.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kn.service.UserService;

public class UserServiceTest1 {
	
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("config/jaxws-services.xml");
		UserService user = (UserService) context.getBean("userClient");
		System.out.println(" ************************ ");
		int id = user.getUserIdByName("admin");
		System.out.println(" name 'admin' --> id '" + id + "'");
	}

}
