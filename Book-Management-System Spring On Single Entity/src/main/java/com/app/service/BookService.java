package com.app.service;

import java.util.List;

import com.app.entity.Book;


//abstract method for performing CRUD On entity Book
public interface BookService {

	//method for saving Book detail
	Book saveBook(Book book);

	//method for fetch Book detail
	Book fetchBookById(int id);
	

	//method for update Book detail
	Book updateBookById(Book book,int id);

	//method for delete Book detail
	void deleteBookById(int id);
	
	
	List<Book> getAllBooks();
	
}
