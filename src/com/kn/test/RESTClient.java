package com.kn.test;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class RESTClient {

	public static void main(String[] args) throws Exception {
		go("http://localhost:8080/CxfServer/services/rest/customer/1/info");
		newgo("http://localhost:8080/CxfServer/services/rest/customer/search?name=abc");
		go("http://localhost:8080/CxfServer/services/rest/hello/sayHello/kn");
	}

	private static void go(String url) throws Exception {
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(url);
		int statusCode = client.executeMethod(method);
		if (statusCode != HttpStatus.SC_OK) {
			System.err.println("Method failed: " + method.getStatusLine());
		}
		byte[] responseBody = method.getResponseBody();
		System.out.println(new String(responseBody));
	}

	private static void newgo(String url) throws Exception {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse httpResponse = client.execute(httpGet);
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		if (statusCode != HttpStatus.SC_OK) {
			System.err.println("Method failed: " + statusCode);
		} else {
			HttpEntity entity = httpResponse.getEntity();
			System.out.println(EntityUtils.toString(entity));
			System.out.println("invoke success!");
		}
	}
}
