package com.shop.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity   //Entity class
 
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	int bookId;
	
	@Column(length=30 ,nullable=false)
	@NotBlank(message = "Enter Book Name")
	String bookName;
	
	@Column(length=30 ,nullable=false)
	@NotBlank(message = "Enter Book category")
	String bookCategory;
	
	@Column(length=20 ,nullable=false)
	@NotBlank(message = "Enter Book Author Name")
	String authorName;
	
	@Column(length=15 ,nullable=false)
	@NotBlank(message = "Enter Book Publish Year")
	String publishedYear;
	
	@Column(length=15 ,nullable=false)
	@NotBlank(message = "Enter date Of Book Given ")
	String dateOfBookGiven;
	
	@Column(length=15 ,nullable=false)
	@NotBlank(message = "Enter  date Of Book return")
	String dateOfBookreturn;

	@ManyToOne(fetch = FetchType.EAGER ,cascade = CascadeType.ALL )
	@JoinColumn(name="userId" ,referencedColumnName="uId")
	@JsonBackReference
	private User user;
	
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

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(String publishedYear) {
		this.publishedYear = publishedYear;
	}

	public String getDateOfBookGiven() {
		return dateOfBookGiven;
	}

	public void setDateOfBookGiven(String dateOfBookGiven) {
		this.dateOfBookGiven = dateOfBookGiven;
	}

	public String getDateOfBookreturn() {
		return dateOfBookreturn;
	}

	public void setDateOfBookreturn(String dateOfBookreturn) {
		this.dateOfBookreturn = dateOfBookreturn;
	}
	
	

	public Book(int bookId, @NotBlank(message = "Enter Book Name") String bookName,
			@NotBlank(message = "Enter Book Name") String bookCategory,
			@NotBlank(message = "Enter Book Name") String authorName,
			@NotBlank(message = "Enter Book Name") String publishedYear,
			@NotBlank(message = "Enter Book Name") String dateOfBookGiven,
			@NotBlank(message = "Enter Book Name") String dateOfBookreturn, User user) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookCategory = bookCategory;
		this.authorName = authorName;
		this.publishedYear = publishedYear;
		this.dateOfBookGiven = dateOfBookGiven;
		this.dateOfBookreturn = dateOfBookreturn;
		this.user = user;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
