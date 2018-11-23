package com.adonayg.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.adonayg.domain.Author;
import com.adonayg.repository.AuthorRepository;
import com.adonayg.util.Util;

public class AuthorService {

	@Inject
	AuthorRepository authorRepository;
	
	@Inject
	Util util;
	
	public String createAuthor(String author) {
		authorRepository.createAuthor(util.getObjectForJSON(author, Author.class));
		return "{\"message\": \"Author has been sucessfully added\"}"; 
	}

	
	public String getAllAuthors() {
		return util.getJSONForObject(authorRepository.getAllAuthors());
	}
	public String deleteAuthor(Long id) {
		authorRepository.deleteAuthor(id);
		return "{\"message\": \"Author sucessfully deleted\"}";
	}
	
	public String getAuthor(Long id) {
		return util.getJSONForObject(authorRepository.findAuthor(id));
	
	}
	
	public void setAuthorRepository(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
		
	public void setutil(Util util) {
		this.util = util;
	}
}