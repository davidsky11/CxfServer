package com.kn.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.kn.bean.User;

@WebService
public interface UserService {

	@WebMethod
	@WebResult String addUser(@WebParam String name, @WebParam int age);
	
	@WebMethod
	@WebResult int deleteUser(@WebParam String id);
	
	@WebMethod
	@WebResult List<User> list();
	
	@WebMethod
	@WebResult int getUserIdByName(@WebParam String name) throws Exception;
}
