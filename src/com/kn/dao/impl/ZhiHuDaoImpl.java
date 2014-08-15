package com.kn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.kn.bean.Comments;
import com.kn.bean.ZhiHu;
import com.kn.dao.ZhiHuDao;

public class ZhiHuDaoImpl extends CommonDaoImpl<ZhiHu> implements ZhiHuDao {

	@Override
	public ZhiHu getZhiHuByById(long zhihuId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ZhiHu> getZhiHuByUsername(String username) {
		System.out.println(" >>> ZhiHuDaoImpl >>> getZhiHuByUsername　>>> ");
		
		List<ZhiHu> list = new ArrayList<ZhiHu>();
		
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		
		String hql = "from ZhiHu zh where zh.username =:username";
		Query query = session.createQuery(hql);
		query.setString("username", username);
		
		list = (List<ZhiHu>) query.list();
		System.out.println(" getCommentsByUsernameAndZhihuId in list.size : " + list.size());
		
		session.close();
		session = null;
		
		return list;
	}

	@Override
	public void insertZhiHu(ZhiHu comm) {
		// TODO Auto-generated method stub

	}

}
