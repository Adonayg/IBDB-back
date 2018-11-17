package com.adonayg.ibdb.services;

import javax.inject.Inject;

import com.adonayg.ibdb.domain.Book;
import com.adonayg.ibdb.repository.BookRepository;
import com.adonayg.ibdb.util.JSONConvert;

public class BookServices {

	@Inject
	BookRepository bookRepository;
	
	@Inject
	JSONConvert jsonConvert;
	
	public String createBook(String book) {
		bookRepository.createBook(jsonConvert.getObjectForJSON(book, Book.class));
		return "{\"message\": \"Book has been sucessfully added\"}"; 
	}
	

	public String deleteBook(Long id) {
		bookRepository.deleteBook(id);
		return "{\"message\": \"Book sucessfully deleted\"}";
	}
	
	public String getBook(Long id) {
		return jsonConvert.getJSONForObject(bookRepository.findBook(id));
	
	}
	public String getAllBooks() {
		return jsonConvert.getJSONForObject(bookRepository.getAllBooks());
	}
	
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
		
	public void setJsonConvert(JSONConvert jsonConvert) {
		this.jsonConvert = jsonConvert;
	}

}
