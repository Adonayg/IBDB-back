package com.adonayg.ibdb.author.repository;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.adonayg.domain.Author;
import com.adonayg.repository.AuthorRepository;

import javax.inject.Inject;

import static org.junit.Assert.*;


@RunWith(Arquillian.class)
public class AuthorRepositoryTest {

    private static Long authorId;


    @Inject
    private AuthorRepository authorRepository;

    @Deployment
    public static Archive<?> createDeploymentPackage() {

        return ShrinkWrap.create(JavaArchive.class)
            .addClass(Author.class)
            .addClass(AuthorRepository.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsManifestResource("META-INF/test-persistence.xml", "persistence.xml");
    }


    @Test
    @InSequence(1)
    public void deploymentTest() {
        assertNotNull(authorRepository);
    }

    @Test
    @InSequence(2)
    public void getAllAuthorTest() {

        assertEquals(Long.valueOf(0), authorRepository.authorCount());

        assertEquals(0, authorRepository.getAllAuthors().size());
    }

    @Test
    @InSequence(3)
    public void CreateAuthorTest() {
    	
    	Author author = new Author("name", "book", "imageUrl");
        author = authorRepository.createAuthor(author);

        assertNotNull(author);
        assertNotNull(author.getId());
        authorId = author.getId();
    }

    @Test
    @InSequence(4)
    public void findAuthorTest() {

        Author authorFound = authorRepository.findAuthor(authorId);

        assertNotNull(authorFound.getId());
        assertEquals("name", authorFound.getName());
    }
    
    @Test
    @InSequence(5)
    public void updateAuthorTest() {
    	 Author authorFound = authorRepository.findAuthor(authorId);
    	 authorFound.setName("test");
    	 Author authorUpdated = authorRepository.updateAuthor(authorFound);
    	 assertEquals("test", authorUpdated.getName());
    }

    @Test
    @InSequence(6)
    public void CountAuthorsTest() {

        assertEquals(Long.valueOf(1), authorRepository.authorCount());

        assertEquals(1, authorRepository.getAllAuthors().size());
    }

    @Test
    @InSequence(7)
    public void deleteAuthorTest() {

        authorRepository.deleteAuthor(authorId);

        Author authorDeleted = authorRepository.findAuthor(authorId);
        assertNull(authorDeleted);
    }

    @Test
    @InSequence(8)
    public void getAllTest() {

        assertEquals(Long.valueOf(0), authorRepository.authorCount());

        assertEquals(0, authorRepository.getAllAuthors().size());
    }
  
}
