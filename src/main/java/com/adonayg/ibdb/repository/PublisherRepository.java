package com.adonayg.ibdb.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.adonayg.ibdb.domain.Publisher;
import com.adonayg.ibdb.util.JSONConvert;




// Class to add stuff to database


@Transactional(SUPPORTS)
@Default
public class PublisherRepository{
	
	@PersistenceContext(unitName = "ibdbPU")
	private EntityManager em;
	
	@Inject
	private JSONConvert jsonConvert;
	
	
	public String getAllPublishers() {
		Query query = em.createQuery("Select a FROM Publisher a");
		Collection<Publisher> publishers = (Collection<Publisher>) query.getResultList();
		// Converting Object to JSON
		return jsonConvert.getJSONForObject(publishers);
	}
	
	
	@Transactional(REQUIRED)
	public String addPublisher(String publisher) {
		Publisher aPublisher = jsonConvert.getObjectForJSON(publisher, Publisher.class);
		em.persist(aPublisher);
		return "{\"message\": \"publisher has been sucessfully added\"}";
	}
	
	
	@Transactional(REQUIRED)
	public String deletePublisher(Long id) {
		Publisher publisherInDB = findPublisher(id);
		if (publisherInDB != null) {
			em.remove(publisherInDB);
		}
		return "{\"message\": \"publisher sucessfully deleted\"}";
	}

	private Publisher findPublisher(Long id) {
		return em.find(Publisher.class, id);
	}
	
	public void setManager(EntityManager em) {
		this.em = em;
	}
	
	public void setUtil(JSONConvert jsonConvert) {
		this.jsonConvert = jsonConvert;
	}


}