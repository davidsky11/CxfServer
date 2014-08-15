package com.kn.service.impl;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import com.kn.bean.ZhiHuList;
import com.kn.service.RestZhiHuService;

public class RestZhiHuServiceImpl implements RestZhiHuService {

	public ZhiHuList findUserByName(@PathParam("username") String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addZhiHuGet(@QueryParam("text") String text,
			@QueryParam("source") String source,
			@QueryParam("username") String username,
			@QueryParam("longitude") String longitude,
			@QueryParam("latitude") String latitude) {
		// TODO Auto-generated method stub

	}

	@Override
	@POST
	@Path("/add")
	public void addZhiHuPost(@QueryParam("text") String text,
			@QueryParam("source") String source,
			@QueryParam("username") String username,
			@QueryParam("longitude") String longitude,
			@QueryParam("latitude") String latitude) {
		// TODO Auto-generated method stub

	}

	@Override
	@GET
	@Path("/search")
	public ZhiHuList findAllZhiHu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GET
	@Path("/searchByCount")
	public ZhiHuList findAllZhiHuByCount(@QueryParam("count") int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GET
	@Path("/searchByStartEnd")
	public ZhiHuList fidnAllZhiHuByStartEnd(@QueryParam("start") int start,
			@QueryParam("end") int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GET
	@Path("/addRepostsCountG")
	public void addRepostsCountGet(@QueryParam("id") int id,
			@QueryParam("username") String username) {
		// TODO Auto-generated method stub

	}

	@Override
	@POST
	@Path("/addRepostsCountP")
	public void addRepostsCountPost(@QueryParam("id") int id,
			@QueryParam("username") String username) {
		// TODO Auto-generated method stub

	}

	@Override
	@GET
	@Path("/addAttitudesCountG")
	public void addAttitudesCountGet(@QueryParam("id") int id,
			@QueryParam("username") String username) {
		// TODO Auto-generated method stub

	}

	@Override
	@POST
	@Path("/addAttitudesCountP")
	public void addAttitudesCountPost(@QueryParam("id") int id,
			@QueryParam("username") String username) {
		// TODO Auto-generated method stub

	}

}
