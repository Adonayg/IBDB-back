package com.adonayg.domain;

import javax.persistence.*;

@Entity
public class Book {

	@Id
	@GeneratedValue
	private Long id;
	private String isbn;

	@Column(length = 200)
	private String title;

	@Column(length = 10000)
	private String description;

	// body refers to more information about the book.
	@Column(length = 20000)
	private String body;

	@Column(name = "publisher_id")
	private Long publisherId;

	@Column(length = 200)
	private String author;
	
	@Column(name="ibdb_rating")
	private Integer ibdbRating;

	@Column(name = "image_url")
	private String imgUrl;

    public Book() {
    }
    
    

	public Book(String isbn, String title, String description, String body, Long publisherId, String author, Integer ibdbRating, String imgUrl) {
		this.isbn = isbn;
		this.title = title;
		this.description = description;
		this.body = body;
		this.publisherId = publisherId;
		this.author = author;
		this.ibdbRating = ibdbRating;
		this.imgUrl = imgUrl;
	}



	public Long getId() {
		return id;
	}


	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Long getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Long publisherId) {
		this.publisherId = publisherId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getIbdbRating() {
		return ibdbRating;
	}

	public void setIbdbRating(Integer ibdbRating) {
		this.ibdbRating = ibdbRating;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
    
}

