package com.kn.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.kn.bean.User;
import com.kn.dao.UserDao;

@Component("userDao")
public class UserDaoImpl extends CommonDaoImpl<User> implements UserDao {

	@Override
	public int getIdByName(String username) throws Exception {
		System.out.println(" >>> UserDaoImpl <<< getIdByName --- ");
		
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		
		String hql = "select u.id from User u where u.name =:username";
		Query query = session.createQuery(hql);
		query.setString("username", username);
		
		String id= (String)query.list().get(0);
		session.close();
		session = null;
		
		return Integer.parseInt(id);
	}

}
