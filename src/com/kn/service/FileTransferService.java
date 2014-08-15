package com.kn.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.kn.bean.MyFile;
import com.kn.exception.FileTransferException;

@WebService
public interface FileTransferService {

	@WebMethod
	void uploadFile(MyFile myFile) throws FileTransferException;
	
	@WebMethod
	MyFile downloadFile(MyFile myFile) throws FileTransferException;
}
