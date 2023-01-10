package com.shop.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.shop.entity.Book;

public interface Bookservice {

	
	//Method for Add Book Detail
	public Book addBook(Book book);
	
	//Method for fetch Book Detail by ID
	public Book getBookById(int bId);
	
	//Method for update Book Detail 
	public Book updateBookById(Book book , int bId);
	
	//Method for fetch All Book Detail
	public List<Book> getAllBook();
	
	//Method for delete Book Detail By Id
	public void deleteBookById(int bId);
	
	//Method for fetch Book Detail By bookCategory 
	List<Book> getBookByCategory(String bookCategory);
	
	//Method for fetch Book Detail By  authorName
	List<Book> getBookByauthorName(String authorName);
	
}
