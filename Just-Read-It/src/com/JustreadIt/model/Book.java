

package com.JustreadIt.model;

import java.util.Objects;

public class Book {

	private int bookId;
	private String bookName;
	private String authorName;
	private String publisherName;
	private double rentalPrice;
	
	public Book(int bookId, String bookName, String authorName, String publisherName, double rentalPrice) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.publisherName = publisherName;
		this.rentalPrice = rentalPrice;
	}

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

	public double getRentalPrice() {
		return rentalPrice;
	}

	public void setRentalPrice(double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authorName, bookId, bookName, publisherName, rentalPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(authorName, other.authorName) && bookId == other.bookId
				&& Objects.equals(bookName, other.bookName) && Objects.equals(publisherName, other.publisherName)
				&& Double.doubleToLongBits(rentalPrice) == Double.doubleToLongBits(other.rentalPrice);
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + ", publisherName="
				+ publisherName + ", rentalPrice=" + rentalPrice + "]";
	}
         	
}
