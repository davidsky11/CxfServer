package com.kn.test;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import com.kn.service.impl.CustomerServiceImpl;

public class ServerTest1 {

	public static void main(String[] args) throws InterruptedException {
		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(CustomerServiceImpl.class);
		
		factory.setAddress("http://localhost:8080/CxfServer");
		factory.create();
		
		System.out.println(" >>> Server1 start ... ");
		Thread.sleep(60 * 1000);
		System.out.println(" >>> Server1 exit ... ");
		System.exit(0);
	}
}
