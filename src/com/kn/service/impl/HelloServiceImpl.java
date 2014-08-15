package com.kn.service.impl;

import javax.jws.WebService;

import com.kn.service.HelloService;

@WebService
//@Component
//@WebService(serviceName = "HelloService", endpointInterface = "com.kn.service.HelloService", targetNamespace = "http://service.kn.com/")
// @SOAPBinding(style=Style.RPC)
//@org.apache.cxf.interceptor.InInterceptors(interceptors = {
//		"org.apache.cxf.transport.common.gzip.GZIPInInterceptor",
//		"org.apache.cxf.transport.common.gzip.GZIPOutInterceptor" })
public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String name) {
		return "Hello " + name;
	}

}
