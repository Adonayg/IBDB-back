package com.adonayg.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.adonayg.service.AuthorService;

@Path("/authors")
public class AuthorEndpoint {
	
	@Inject
	private AuthorService service;

	@GET
	@Produces({ "application/json" })
	public String getAllAuthors() {
		return service.getAllAuthors();
	}
	
	@Path("/{id}")
	@GET
	@Produces({ "application/json" })
	public String getAuthor(@PathParam("id") Long id) {
		return service.getAuthor(id);
	}


	@Path("/createAuthor")
	@POST
	@Produces({ "application/json" })
	public String createAuthor(String author) {
		return service.createAuthor(author);
	}

	@Path("/deleteAuthor/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAuthor(@PathParam("id") Long id) {
		return service.deleteAuthor(id);
	}

	public void setService(AuthorService service) {
		this.service = service;
	}

}
