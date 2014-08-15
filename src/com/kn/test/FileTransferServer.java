package com.kn.test;

import javax.xml.ws.Endpoint;

import com.kn.service.impl.FileTransferServiceImpl;

public class FileTransferServer {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/CxfServer/FileTransferService",
				new FileTransferServiceImpl());
	}
}
