package com.kn.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.kn.bean.BigData;

@WebService
public interface BigDataService {

	@WebMethod
	@WebResult BigData getBigData(@WebParam String name, @WebParam int size);
}
