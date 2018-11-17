package com.adonayg.ibdb.services;

import javax.inject.Inject;

import com.adonayg.ibdb.repository.PublisherRepository;

public class PublisherServices {

	@Inject
	private PublisherRepository repo;

	public String addPublisher(String publisher) {
		return repo.addPublisher(publisher);
	}


	public String deletePublisher(Long id) {
		return repo.deletePublisher(id);
	}
	
	
	public String getAllPublishers() {
		return repo.getAllPublishers();
	}
	
	public void setRepo(PublisherRepository repo) {
		this.repo = repo;
	}
}