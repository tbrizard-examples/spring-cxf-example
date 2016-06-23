package com.springcxfdemo.clientservice.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.springcxfdemo.clientservice.webservice.resources.ClientResource;

/**
 * 
 * note: things like Swagger annotations have been omitted for the purposes of this example
 */
@Path("/")
public interface RESTClientService {

	@Path("/clients/{clientId}/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	ClientResource findClient(@PathParam("clientId") String clientId);
}
