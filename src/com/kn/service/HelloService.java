package com.kn.service;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(value = "/hello")
@Produces("*/*")
@WebService
public interface HelloService {
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML})
	@Path(value="/sayHello/{name}")
	@WebMethod
	@WebResult String sayHello(@PathParam("name")String name);
}
