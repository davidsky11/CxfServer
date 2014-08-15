package com.kn.service;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.kn.bean.Customer;

@Path(value="/customer")
@Produces("*/*")
@WebService
public interface CustomerService {

	//@WebMethod
	//@WebResult Customer findCustomer(@WebParam String id);
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML})
	@Path(value="/{id}/info")
	@WebMethod
	@WebResult Customer findCustomerById(@PathParam("id")String id);
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML})
	@Path(value="/search")
	@WebMethod
	@WebResult Customer findCustomerByName(@QueryParam("name")String name);
}
