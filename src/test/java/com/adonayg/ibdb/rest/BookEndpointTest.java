//package com.adonayg.ibdb.rest;
//
//import org.jboss.arquillian.container.test.api.Deployment;
//import org.jboss.arquillian.container.test.api.RunAsClient;
//import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
//import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.arquillian.junit.InSequence;
//import org.jboss.shrinkwrap.api.Archive;
//import org.jboss.shrinkwrap.api.ShrinkWrap;
//import org.jboss.shrinkwrap.api.asset.EmptyAsset;
//import org.jboss.shrinkwrap.api.spec.WebArchive;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import com.adonayg.ibdb.domain.Book;
//import com.adonayg.ibdb.domain.Publisher;
//import com.adonayg.ibdb.repository.BookRepository;
//
//import javax.ws.rs.client.Entity;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.core.Response;
//import java.util.Date;
//import java.util.List;
//
//import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
//import static javax.ws.rs.core.Response.Status.*;
//import static org.junit.Assert.*;
//
//
//@RunWith(Arquillian.class)
//@RunAsClient
//public class BookEndpointTest {
//
//
//    private static String bookId;
//    private Response response;
//
//
//    @Deployment(testable = false)
//    public static Archive<?> createDeploymentPackage() {
//
//        return ShrinkWrap.create(WebArchive.class)
//            .addClass(Book.class)
//            .addClass(Publisher.class)
//            .addClass(BookRepository.class)
//            .addClass(BookEndpoint.class)
//            .addClass(JAXActivator.class)
//            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
//            .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml");
//    }
//
//
//    @Test
//    @InSequence(2)
//    public void getRequestTest(@ArquillianResteasyResource("api/books") WebTarget webTarget) {
//        // Count all
//        response = webTarget.path("count").request().get();
//        assertEquals(NO_CONTENT.getStatusCode(), response.getStatus());
//        // Find all
//        response = webTarget.path("getBooks").request(APPLICATION_JSON).get();
//        assertEquals(NO_CONTENT.getStatusCode(), response.getStatus());
//    }
//}