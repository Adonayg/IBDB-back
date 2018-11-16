package com.adonayg.ibdb.repository;

import com.adonayg.ibdb.domain.*;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(Arquillian.class)
public class BookRepositoryTest {



    private static Long bookId;
    private static String bookTitle;

    @Inject
    private BookRepository bookRepository;
   

    @Deployment
    public static Archive<?> createDeploymentPackage() {

        return ShrinkWrap.create(JavaArchive.class)
            .addClass(Book.class)
            .addClass(Publisher.class)
            .addClass(BookRepository.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsManifestResource("META-INF/test-persistence.xml", "persistence.xml");
    }


    @Test
    @InSequence(1)
    public void deploymentTest() {
        assertNotNull(bookRepository);
    }

    @Test
    @InSequence(2)
    public void getAllBookTest() {

        assertEquals(Long.valueOf(0), bookRepository.bookCount());

        assertEquals(0, bookRepository.getAllBooks().size());
    }

    @Test
    @InSequence(3)
    public void CreateBookTest() {

		List<Book> publishersBooks = new ArrayList<Book>();
		Publisher publisher = new Publisher("name", publishersBooks);
    	Book book = new Book("isbn", "title", "description", "body", publisher.getId(), "author", 5,"imgUrl");
        book = bookRepository.createBook(book);

        assertNotNull(book);
        assertNotNull(book.getId());
        bookId = book.getId();
        bookTitle = book.getTitle();
    }

    @Test
    @InSequence(4)
    public void findBookTest() {

        Book bookFound = bookRepository.findBook(bookId);
        List<Book> titleSearchBooks = bookRepository.findBook(bookTitle);

        assertNotNull(bookFound.getId());
        assertEquals("title", bookFound.getTitle());
        assertEquals(bookRepository.getAllBooks().size(), titleSearchBooks.size());
    }
    
    @Test
    @InSequence(5)
    public void updateBookTest() {
    	 Book bookFound = bookRepository.findBook(bookId);
    	 bookFound.setTitle("test");
    	 Book bookUpdated = bookRepository.updateBook(bookFound);
    	 assertEquals("test", bookUpdated.getTitle());
    }

    @Test
    @InSequence(6)
    public void CountBooksTest() {

        assertEquals(Long.valueOf(1), bookRepository.bookCount());

        assertEquals(1, bookRepository.getAllBooks().size());
    }

    @Test
    @InSequence(7)
    public void deleteBookTest() {

        bookRepository.deleteBook(bookId);

        Book bookDeleted = bookRepository.findBook(bookId);
        assertNull(bookDeleted);
    }

    @Test
    @InSequence(8)
    public void getAllTest() {

        assertEquals(Long.valueOf(0), bookRepository.bookCount());

        assertEquals(0, bookRepository.getAllBooks().size());
    }
    
  
}
