package com.kn.test;

import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.WebServiceException;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kn.bean.User;
import com.kn.handler.ClientUsernamePasswordHandler;
import com.kn.handler.ServerUsernamePasswordHandler;
import com.kn.service.UserService;
import com.kn.service.impl.UserServiceImpl;

public class UserServiceTest {

	private static final String address = "http://localhost:8080/CxfServer/UserService";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
		factoryBean.getInInterceptors().add(new LoggingInInterceptor());
		factoryBean.getOutInterceptors().add(new LoggingOutInterceptor());

		Map<String, Object> props = new HashMap<String, Object>();
		props.put("action", "UsernameToken");
		props.put("passwordType", "PasswordText");
		props.put("passwordCallbackClass",
				ServerUsernamePasswordHandler.class.getName());
		WSS4JInInterceptor wss4JInInterceptor = new WSS4JInInterceptor(props);
		factoryBean.getInInterceptors().add(wss4JInInterceptor);

		factoryBean.setServiceClass(UserServiceImpl.class);
		factoryBean.setAddress(address);
		factoryBean.create();
	}

	@Test
	public void testList() {
		JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
		factoryBean.setAddress(address);
		factoryBean.setServiceClass(UserService.class);
		Object obj = factoryBean.create();

		Client client = ClientProxy.getClient(obj);
		Endpoint endpoint = client.getEndpoint();

		Map<String, Object> props = new HashMap<String, Object>();
		props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
		props.put(WSHandlerConstants.USER, "admin");
		props.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
		props.put(WSHandlerConstants.PW_CALLBACK_CLASS,
				ClientUsernamePasswordHandler.class.getName());
		WSS4JOutInterceptor wss4JOutInterceptor = new WSS4JOutInterceptor(props);
		endpoint.getOutInterceptors().add(wss4JOutInterceptor);

		HTTPConduit conduit = (HTTPConduit) client.getConduit();
		HTTPClientPolicy policy = new HTTPClientPolicy();
		policy.setConnectionTimeout(5 * 1000);
		policy.setReceiveTimeout(5 * 1000);
		conduit.setClient(policy);

		UserService service = (UserService) obj;
		try {
			List<User> users = service.list();
			Assert.assertNotNull(users);
			Assert.assertEquals(10, users.size());
		} catch (Exception e) {
			if (e instanceof WebServiceException
					&& e.getCause() instanceof SocketTimeoutException) {
				System.err.println("This is timeout exception.");
			} else {
				e.printStackTrace();
			}
		}
	}
}
