package com.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Book;
import com.app.exception.BookNotFoundException;
import com.app.repository.BookRepository;
import com.app.service.BookService;


@Service
public class BookServiceImpl implements BookService{

	@Autowired
	 BookRepository brepo;
	

	@Override
	public Book saveBook(Book book) {
		
		return brepo.save(book);
	}
	
	@Override
	public Book fetchBookById(int id) {
		return brepo.findById(id).orElseThrow(() -> new BookNotFoundException("id does Not Exist in system"));
	}


	@Override
	public Book updateBookById(Book book, int id) {
		
	Book book1=	brepo.findById(id).orElseThrow(() -> new BookNotFoundException("id does not Exist in System"));
		 book1.setPrice(book.getPrice());
		 brepo.save(book1);
		 return book1;
	}


	@Override
	public void deleteBookById(int id) {

		 brepo.findById(id).orElseThrow(() -> new BookNotFoundException("id does Not exist in System"));
		 brepo.deleteById(id);
	}


	@Override
	public List<Book> getAllBooks() {
		
		return brepo.findAll();
	}

}
