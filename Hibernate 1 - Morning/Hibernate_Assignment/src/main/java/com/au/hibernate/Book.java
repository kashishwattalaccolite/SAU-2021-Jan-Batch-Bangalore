package com.au.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Book")
public class Book {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		
		@Column
		private String name;
		
		@Column
		private String author;
		
		@Column
		private String publisher;
		
		public Book()
		{}
		public Book( String name, String author, String publisher) {
			super();
		
			this.name = name;
			this.author = author;
			this.publisher = publisher;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getPublisher() {
			return publisher;
		}

		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}
	
		
}