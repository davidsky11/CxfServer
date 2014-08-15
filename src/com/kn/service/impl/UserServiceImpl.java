package com.kn.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.kn.bean.User;
import com.kn.dao.UserDao;
import com.kn.service.UserService;

@Component("userService")
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public String addUser(String name, int age) {
		return "add user with " + name + " and " + age;
	}
	
	@Override
	public int deleteUser(String id) {
		return id.length();
	}

	@Override
	public List<User> list() {
		System.out.println(" >>> UserServiceImpl <<< ");
		List<User> users = new ArrayList<User>();
		for (int i=0; i<10; i++) {
			User user = new User();
			user.setId("" + i);
			user.setName("user_" + i);
			user.setPassword("password_" + i);
			users.add(user);
		}
		System.out.println(" >>> UserServiceImpl <<< > ");
		return users;
	}

	@Override
	public int getUserIdByName(String name) throws Exception {
		System.out.println(" >>> UserServiceImpl <<< getUserIdByName --- ");
		
		return userDao.getIdByName(name);
	}
}
