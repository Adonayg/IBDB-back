package com.adonayg.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.adonayg.domain.Author;


@Transactional(SUPPORTS)
@Default
public class AuthorRepository {

	   @PersistenceContext(unitName = "primary")
	    private EntityManager em;


	    public Author findAuthor(Long id) {
	        return em.find(Author.class, id);
	    }
	    
	    public List<Author> getAllAuthors() {
	        TypedQuery<Author> query = em.createQuery("SELECT a FROM Author a", Author.class);
	        return query.getResultList();
	    }
	    
	    public Long authorCount() {
	        TypedQuery<Long> query = em.createQuery("SELECT COUNT(a) FROM Author a", Long.class);
	        return query.getSingleResult();
	    }
	    
	    @Transactional(REQUIRED)
	    public Author createAuthor(Author author) {
	        em.persist(author);
	        return author;
	    }

	    @Transactional(REQUIRED)
	    public void deleteAuthor(Long id) {
	        em.remove(em.getReference(Author.class, id));
	    }
	    
	    @Transactional(REQUIRED)
	    public Author updateAuthor(Author author) {
	    	Author authorInDb = findAuthor(author.getId());
	    	authorInDb.setName(author.getName());
	    	authorInDb.setImageUrl(author.getImageUrl());
	    	return authorInDb;
	    }
	    
	    
		public void setManager(EntityManager em) {
			this.em = em;
		}
}
