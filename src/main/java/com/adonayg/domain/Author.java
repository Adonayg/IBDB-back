package com.adonayg.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Author {
		@Id
		@GeneratedValue
		private Long id;

		@Column(length = 200)
		private String name;
		
		private String book;
		
		@Column(name = "image_url")
		private String imageUrl;

		public Author(String name, String book, String imageUrl) {

			this.name = name;
			this.book = book;
			this.imageUrl = imageUrl;
		}
		
		public Author() {
			
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getBooks() {
			return book;
		}

		public void setBooks(List<String> books) {
			this.book = book;
		}

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		
		
}
