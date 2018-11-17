package com.adonayg.ibdb.rest;

import javax.inject.Inject;
import javax.ws.rs.*;

import com.adonayg.ibdb.services.BookServices;


@Path("/books")
public class BookEndpoint {

	@Inject
	private BookServices service;

	@Path("/getAllBooks")
	@GET
	@Produces({ "application/json" })
	public String getAllBooks() {
		return service.getAllBooks();
	}

	@Path("/createBook")
	@POST
	@Produces({ "application/json" })
	public String createBook(String book) {
		return service.createBook(book);
	}

	@Path("/deleteBook/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteBook(@PathParam("id") Long id) {
		return service.deleteBook(id);
	}

	@Path("/getBook/{id}")
	@GET
	@Produces({ "application/json" })
	public String getBook(@PathParam("id") Long id) {
		return service.getBook(id);
	}
	public void setService(BookServices service) {
		this.service = service;
	}
	
}

