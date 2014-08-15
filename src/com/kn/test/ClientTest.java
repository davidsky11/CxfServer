package com.kn.test;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.kn.service.UserService;

public class ClientTest {

	public static void main(String[] args) {  
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();  
        factory.setServiceClass(UserService.class);  
        factory.setAddress("http://localhost:8080/CxfServer/UserService");  
        UserService user = (UserService) factory.create();  
        System.out.println(user.addUser("kn", 21));  
        System.exit(0);  
    } 
}
