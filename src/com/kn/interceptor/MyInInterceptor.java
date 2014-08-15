package com.kn.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.AbstractHTTPDestination;

public class MyInInterceptor extends AbstractPhaseInterceptor<Message> {

	public MyInInterceptor(String phase) {
		super(phase);
	}
	
	public MyInInterceptor() {
		super(Phase.RECEIVE);
	}

	@Override
	public void handleMessage(Message message) throws Fault {
		HttpServletRequest request = (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);
		System.out.println("请求的字符集编码 : " + request.getCharacterEncoding());
		System.out.println("请求的URL : " + request.getRequestURL());
		
		String ip = request.getRemoteAddr();
		System.out.println(request.getRequestURI());
		
		Enumeration<String> e = request.getHeaderNames();
		while (e.hasMoreElements()) {
			String str = e.nextElement();
			System.out.println(str + "   " + request.getHeader(str));
		}
		System.out.println(ip);
	}

}
