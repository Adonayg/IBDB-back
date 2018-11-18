package com.adonayg.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.adonayg.domain.Book;
import com.adonayg.repository.BookRepository;
import com.adonayg.util.Util;

public class BookService {

	@Inject
	BookRepository bookRepository;
	
	@Inject
	Util util;
	
	public String createBook(String book) {
		bookRepository.createBook(util.getObjectForJSON(book, Book.class));
		return "{\"message\": \"Book has been sucessfully added\"}"; 
	}
	
	
    public String getBook(String title) {
    	List<Book> allBooks = bookRepository.getAllBooks();
    	return util.getJSONForObject(allBooks.stream().filter( book -> book.getTitle().contains(title)).collect(Collectors.toList()));
    }

	
	
	public String getAllBooks() {
		return util.getJSONForObject(bookRepository.getAllBooks());
	}
	public String deleteBook(Long id) {
		bookRepository.deleteBook(id);
		return "{\"message\": \"Book sucessfully deleted\"}";
	}
	
	public String getBook(Long id) {
		return util.getJSONForObject(bookRepository.findBook(id));
	
	}
	
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
		
	public void setutil(Util util) {
		this.util = util;
	}

	
}