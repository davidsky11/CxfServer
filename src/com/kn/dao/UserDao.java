package com.kn.dao;

import com.kn.bean.User;

public interface UserDao extends CommonDao<User> {

	/**
	 * 根据用户名称获取用户ID
	 * @param username
	 * @return
	 * @throws Exception
	 */
	int getIdByName(String username) throws Exception;
}
