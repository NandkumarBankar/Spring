package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name="Book_Detail")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;
	
	@Column(length = 20 ,nullable = false)
	@NotBlank(message = "Enter Book Name")
	private String bookName;
	
	@Column(length = 20 ,nullable = false)
	@NotBlank(message = "Enter Author Name")
	private String authorName;
	
	@Column(length = 20 ,nullable = false)
	@NotBlank(message = "Enter Book Publisher Name")
	private String publisherName;
	
	@Column(length = 20 ,nullable = false,unique = true)
	@NotNull(message = "Enter Book price")
	private String price;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Book( @NotBlank(message = "Enter Book Name") String bookName,
			@NotBlank(message = "Enter Author Name") String authorName,
			@NotBlank(message = "Enter Book Publisher Name") String publisherName,
			@NotNull(message = "Enter Book price") String price) {
		super();
		
		this.bookName = bookName;
		this.authorName = authorName;
		this.publisherName = publisherName;
		this.price = price;
	}

	public Book() {
		super();
	}
	
	
}
