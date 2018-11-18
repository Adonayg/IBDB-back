package com.adonayg.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.adonayg.service.BookService;

@Path("/books")
public class BookEndpoint {
	
	@Inject
	private BookService service;

	@GET
	@Produces({ "application/json" })
	public String getAllBooks() {
		return service.getAllBooks();
	}
	
	@Path("/{id}")
	@GET
	@Produces({ "application/json" })
	public String getBook(@PathParam("id") Long id) {
		return service.getBook(id);
	}
	
	@Path("/{title}")
	@GET
	@Produces({ "application/json" })
	public String getBook(@PathParam("title") String title) {
		return service.getBook(title);
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

	public void setService(BookService service) {
		this.service = service;
	}

}
