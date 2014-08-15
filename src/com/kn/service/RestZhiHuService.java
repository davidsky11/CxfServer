package com.kn.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import com.kn.bean.ZhiHuList;

@Path(value="/zhihu")
public interface RestZhiHuService {

	/**
	 * 根据用户名查询
	 * @param username
	 * @return
	 */
	@GET
	@Path(value="{username}/search")
	public ZhiHuList findUserByName(@PathParam("username")String username);
	
	/**
	 * 通过get方式发布知乎
	 * @param text
	 * @param source
	 * @param username
	 * @param longitude
	 * @param latitude
	 */
	@GET
	@Path(value="/add")
	public void addZhiHuGet(@QueryParam("text")String text, @QueryParam("source")String source,
			@QueryParam("username")String username, @QueryParam("longitude")String longitude,
			@QueryParam("latitude")String latitude);
	
	/**
	 * 通过post方式发布知乎
	 * @param text
	 * @param source
	 * @param username
	 * @param longitude
	 * @param latitude
	 */
	@POST
	@Path(value="/add")
	public void addZhiHuPost(@QueryParam("text")String text, @QueryParam("source")String source,
			@QueryParam("username")String username, @QueryParam("longitude")String longitude,
			@QueryParam("latitude")String latitude);
	
	/**
	 * 得到所有的知乎
	 * @return
	 */
	@GET
	@Path(value="/search")
	public ZhiHuList findAllZhiHu();
	
	/**
	 * 得到最近的知乎
	 * @param count
	 * @return
	 */
	@GET
	@Path(value="/searchByCount")
	public ZhiHuList findAllZhiHuByCount(@QueryParam("count")int count);
	
	/**
	 * 得到start到end之间的知乎
	 * @param start
	 * @param end
	 * @return
	 */
	@GET
	@Path(value="/searchByStartEnd")
	public ZhiHuList fidnAllZhiHuByStartEnd(@QueryParam("start")int start, 
			@QueryParam("end")int end);
	
	/**
	 * 
	 * @param id
	 * @param username
	 */
	@GET
	@Path(value = "/addRepostsCountG")
	public void addRepostsCountGet(@QueryParam("id")int id,
			@QueryParam("username")String username);
	
	/**
	 * 
	 * @param id
	 * @param username
	 */
	@POST
	@Path(value = "/addRepostsCountP")
	public void addRepostsCountPost(@QueryParam("id")int id,
			@QueryParam("username")String username);
	
	/**
	 * 
	 * @param id
	 * @param username
	 */
	@GET
	@Path(value = "/addAttitudesCountG")
	public void addAttitudesCountGet(@QueryParam("id")int id,
			@QueryParam("username")String username);
	
	/**
	 * 
	 * @param id
	 * @param username
	 */
	@POST
	@Path(value = "/addAttitudesCountP")
	public void addAttitudesCountPost(@QueryParam("id")int id,
			@QueryParam("username")String username);
}
