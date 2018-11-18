package com.adonayg.ibdb.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.adonayg.domain.Book;
import com.adonayg.domain.Publisher;
import com.adonayg.util.Util;

public class UtilTest {
	
	private Util util;
	private Publisher publisher;
	private List<Book> publishersBooks;
	private String jsonPublisher;
	
	@Before 
	public void setup() {
		util = new Util();
		publishersBooks = new ArrayList<Book>();
		publisher = new Publisher("name", publishersBooks);
		jsonPublisher = "{\"name\":\"name\",\"books\":[]}";
	}
	
	@Test
	public void getJSONForObjectTest() {
		assertEquals(jsonPublisher, util.getJSONForObject(publisher));

	}
	
	@Test
	public void getObjectForJSONTest() {
	
		assertEquals(publisher.getName(), util.getObjectForJSON(jsonPublisher, Publisher.class).getName());
		assertEquals(publisher.getBooks(), util.getObjectForJSON(jsonPublisher, Publisher.class).getBooks());
	}

}
