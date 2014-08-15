package com.kn.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kn.service.CustomerService;
import com.kn.service.HelloService;
import com.kn.service.UserService;

public class Demo {

	private static ClassPathXmlApplicationContext context = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context = null;
	}
	
	@Test
	public void clientTest() {
		HelloService hello = (HelloService) context.getBean("helloClient");
		System.out.println(" >>> (hello) response from server : " + hello.sayHello("kn"));
		
		UserService user = (UserService) context.getBean("userClient");
		System.out.println(" >>> (user)  response from server : " + user.addUser("sf", 21));
		
		CustomerService customer = (CustomerService) context.getBean("customerClient");
		System.out.println(" >>> (customer) response from server : " + customer.findCustomerById("11"));
		System.exit(0);
	}
}
