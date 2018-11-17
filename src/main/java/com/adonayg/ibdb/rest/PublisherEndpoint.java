package com.adonayg.ibdb.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.adonayg.ibdb.services.PublisherServices;

@Path("/publisher")
public class PublisherEndpoint {

	@Inject
	private PublisherServices service;

	@Path("/getAllPublishers")
	@GET
	@Produces({ "application/json" })
	public String getAllPublishers() {
		return service.getAllPublishers();
	}

	@Path("/addPublisher")
	@POST
	@Produces({ "application/json" })
	public String addPublisher(String publisher) {
		return service.addPublisher(publisher);
	}

	@Path("/deletePublisher/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deletePublisher(@PathParam("id") Long id) {
		return service.deletePublisher(id);
	}

	public void setService(PublisherServices service) {
		this.service = service;
	}

}