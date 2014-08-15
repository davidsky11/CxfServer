package com.kn.interceptor;

import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.AbstractHTTPDestination;

public class MyOutInterceptor extends AbstractPhaseInterceptor<Message> {

	public MyOutInterceptor(String phase) {
		super(phase);
	}
	
	public MyOutInterceptor() {
		super(Phase.SEND);
	}

	@Override
	public void handleMessage(Message message) throws Fault {
		HttpServletResponse response = (HttpServletResponse) message.get(AbstractHTTPDestination.HTTP_RESPONSE);
		response.setCharacterEncoding("utf-8");
		System.out.println("------------------离开拦截器-----------------");
	}

}
