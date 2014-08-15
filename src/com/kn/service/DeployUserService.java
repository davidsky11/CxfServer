package com.kn.service;

import javax.xml.ws.Endpoint;

public class DeployUserService {

	public static void main(String[] args) {
		Endpoint.publish("Http://localhost:8080/user", null);
	}
}
