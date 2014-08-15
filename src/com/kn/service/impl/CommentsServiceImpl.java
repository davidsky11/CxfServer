package com.kn.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.kn.bean.Comments;
import com.kn.dao.CommentsDao;
import com.kn.service.CommentsService;

@Component("commentsService")
public class CommentsServiceImpl implements CommentsService {

	private CommentsDao commentsDao;

	public CommentsDao getCommentsDao() {
		return commentsDao;
	}

	@Resource
	public void setCommentsDao(CommentsDao commentsDao) {
		this.commentsDao = commentsDao;
	}

	@Override
	public List<Comments> findCommentsByName(String username, long zhihuId) {
		return commentsDao.getCommentsByUsernameAndZhihuId(username, zhihuId);
	}

	@Override
	public void insertCommentGet(String text, String source, String username,
			long zhihuId, String reply_comment) {
		Comments comm = new Comments();
		comm.setText(text);
		comm.setCreated_at(new Date());
		comm.setSource(source);
		comm.setUsername(username);
		comm.setZhihuId(zhihuId);
		comm.setReply_comment(reply_comment);

		commentsDao.insertComments(comm);
	}

	@Override
	public void insertCommentPost(String text, String source, String username,
			long zhihuId, String reply_comment) {
		Comments comm = new Comments();
		comm.setText(text);
		comm.setCreated_at(new Date());
		comm.setSource(source);
		comm.setUsername(username);
		comm.setZhihuId(zhihuId);
		comm.setReply_comment(reply_comment);

		commentsDao.insertComments(comm);
	}

}
