package com.kn.test;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.transport.common.gzip.GZIPInInterceptor;
import org.apache.cxf.transport.common.gzip.GZIPOutInterceptor;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kn.bean.BigData;
import com.kn.service.BigDataService;
import com.kn.service.impl.BigDataServiceImpl;

public class BigDataServiceTest {

	private static final String address = "http://localhost:8080/CxfServer/BigDataService";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
		factoryBean.getInInterceptors().add(new LoggingInInterceptor());
		factoryBean.getOutInterceptors().add(new LoggingOutInterceptor());
		
		// 使用压缩Interceptor来压缩和解压缩数据包
		factoryBean.getInInterceptors().add(new GZIPInInterceptor());
		factoryBean.getOutInterceptors().add(new GZIPOutInterceptor());
		
		factoryBean.setServiceClass(BigDataServiceImpl.class);
		factoryBean.setAddress(address);
		factoryBean.create();
	}
	
	@Test
	public void testGetBigData() {
		JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
		factoryBean.setAddress(address);
		factoryBean.setServiceClass(BigDataService.class);
		Object obj = factoryBean.create();
		
		Client client = ClientProxy.getClient(obj);
		Endpoint endpoint = client.getEndpoint();
		
		// 使用压缩Interceptor来压缩和解压缩数据包
		endpoint.getInInterceptors().add(new GZIPInInterceptor());
		endpoint.getOutInterceptors().add(new GZIPOutInterceptor());
		
		BigDataService service = (BigDataService) obj;
		Assert.assertNotNull(service);
		
		String name = "my big data";
		int size = 1024 * 1024 * 10;
		
		long start = System.currentTimeMillis();
		BigData bigData = service.getBigData(name, size);
		long stop = System.currentTimeMillis();
		System.out.println(" >>> 传输BigData耗时 : " + (stop - start));
		
		Assert.assertNotNull(bigData);
		Assert.assertEquals(name, bigData.getName());
		Assert.assertEquals(size, bigData.getData().length());
	}
}
