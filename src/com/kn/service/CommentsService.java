package com.kn.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.kn.bean.Comments;

@WebService
@Path(value = "/comments")
public interface CommentsService {

	/**
	 * 根据用户名，知乎ID查找
	 * @param name
	 * @param zhihuId
	 * @return
	 */
	@GET
	@Path(value = "/searchbyNameId")
	@WebMethod
	public List<Comments> findCommentsByName(@QueryParam("username")String username, 
			@QueryParam("zhihuId")long zhihuId);
	
	/**
	 * 新增评论get方式
	 * @param text
	 * @param source
	 * @param username
	 * @param zhihuId
	 * @param reply_comment
	 */
	@GET
	@Path(value = "/add")
	@WebMethod
	public void insertCommentGet(@QueryParam("text")String text, @QueryParam("source")String source,
			@QueryParam("username")String username, @QueryParam("zhihuId")long zhihuId,
			@QueryParam("reply_comment")String reply_comment);
	
	/**
	 * 新增评论post方式
	 * @param text
	 * @param source
	 * @param username
	 * @param zhihuId
	 * @param reply_comment
	 */
	@GET
	@Path(value = "/add")
	@WebMethod
	public void insertCommentPost(@QueryParam("text")String text, @QueryParam("source")String source,
			@QueryParam("username")String username, @QueryParam("zhihuId")long zhihuId,
			@QueryParam("reply_comment")String reply_comment);
}
