package com.adonayg.ibdb.repository;

import com.adonayg.ibdb.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;


@Transactional(SUPPORTS)
public class BookRepository {



    @PersistenceContext(unitName = "bookStorePU")
    private EntityManager em;


    public Book findBook(Long id) {
        return em.find(Book.class, id);
    }

    public List<Book> getAllBooks() {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b ORDER BY b.title DESC", Book.class);
        return query.getResultList();
    }

    public Long bookCount() {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(b) FROM Book b", Long.class);
        return query.getSingleResult();
    }

    @Transactional(REQUIRED)
    public Book createBook(Book book) {
        em.persist(book);
        return book;
    }

    @Transactional(REQUIRED)
    public void deleteBook(Long id) {
        em.remove(em.getReference(Book.class, id));
    }
    
    @Transactional(REQUIRED)
    public Book updateBook(Book book) {
    	Book bookInDb = findBook(book.getId());
    	bookInDb.setAuthor(book.getAuthor());
    	bookInDb.setTitle(book.getTitle());
    	bookInDb.setDescription(book.getDescription());
    	bookInDb.setImgUrl(book.getImgUrl());
    	bookInDb.setPublisherId(book.getPublisherId());
    	bookInDb.setBody(book.getBody());
    	return bookInDb;
    }
}
