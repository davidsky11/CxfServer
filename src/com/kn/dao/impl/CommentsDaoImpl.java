package com.kn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.kn.bean.Comments;
import com.kn.dao.CommentsDao;

@Component("commentsDao")
public class CommentsDaoImpl extends CommonDaoImpl<Comments> implements CommentsDao {

	@Override
	public List<Comments> getCommentsByUsernameAndZhihuId(String username, long zhihuId) {
		System.out.println(" >>> CommentsDaoImpl >>>getCommentsByUsernameAndZhihuId　>>> ");
		
		List<Comments> list = new ArrayList<Comments>();
		
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		
		String hql = "from Comments c where c.username =:username and c.zhihuId =:zhihuId";
		Query query = session.createQuery(hql);
		query.setString("username", username);
		query.setLong("zhihuId", zhihuId);
		
		list = (List<Comments>) query.list();
		System.out.println(" getCommentsByUsernameAndZhihuId in list.size : " + list.size());
		
		session.close();
		session = null;
		
		return list;
	}

	@Override
	public void insertComments(Comments comm) {
		System.out.println(" >>> CommentsDaoImpl >>> insertComments >>> ");
		
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		
		if (comm != null) {
			session.save(comm);
		}
		
		session.close();
		session = null;
	}

}
