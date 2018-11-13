package com.adonayg.ibdb.domain;

import javax.persistence.*;


import java.util.Date;


@Entity
public class Book {

	@Id
	@GeneratedValue
	private Long id;
	private String isbn;

	@Column(length = 200)
	private String title;

	@Column(name = "publication_date")
	@Temporal(TemporalType.DATE)
	private Date publicationDate;
	@Column(length = 10000)
	private String description;

	// body refers to more information about the book.
	@Column(length = 20000)
	private String body;

	@Column(name = "publisher_id")
	private Long publisherId;

	@Column(length = 200)
	private String author;

	private Integer googleRating;
	private Integer amazonRating;
	private Integer ibdbRating;

	@Column(name = "image_url")
	private String imgUrl;

    public Book() {
    }
    
    

	public Book(String isbn, String title, Date publicationDate, String description, String body,
			Long publisherId, String author, Integer googleRating, Integer amazonRating, Integer ibdbRating,
			String imgUrl) {
		super();
	
		this.isbn = isbn;
		this.title = title;
		this.publicationDate = publicationDate;
		this.description = description;
		this.body = body;
		this.publisherId = publisherId;
		this.author = author;
		this.googleRating = googleRating;
		this.amazonRating = amazonRating;
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

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
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
		author = author;
	}

	public Integer getGoogleRating() {
		return googleRating;
	}

	public void setGoogleRating(Integer googleRating) {
		this.googleRating = googleRating;
	}

	public Integer getAmazonRating() {
		return amazonRating;
	}

	public void setAmazonRating(Integer amazonRating) {
		this.amazonRating = amazonRating;
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
