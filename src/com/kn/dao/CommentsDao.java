package com.kn.dao;

import java.util.List;

import com.kn.bean.Comments;

public interface CommentsDao extends CommonDao<Comments> {

	public List<Comments> getCommentsByUsernameAndZhihuId(String username, long zhihuId);
	
	public void insertComments(Comments comm);
}
