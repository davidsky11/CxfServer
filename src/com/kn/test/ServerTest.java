package com.kn.test;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import com.kn.service.UserService;

public class ServerTest {

	public static void main(String[] args) throws InterruptedException {
		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
		factory.setServiceClass(UserService.class);
		
		factory.setAddress("http://localhost:8080/CxfServer/UserService");
		factory.create();
		
		System.out.println(" >>> Server start ... ");
		Thread.sleep(60 * 1000);
		System.out.println(" >>> Server exit ... ");
		System.exit(0);
	}
}
