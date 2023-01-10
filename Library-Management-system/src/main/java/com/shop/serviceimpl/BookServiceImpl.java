package com.shop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Book;
import com.shop.exception.BookNotFoundException;
import com.shop.repository.BookRepository;
import com.shop.service.Bookservice;

@Service   //Ser
public class BookServiceImpl implements Bookservice{

	@Autowired
	public BookRepository brepo;
	
	@Override
	public Book addBook(Book book) {
	       return brepo.save(book);
	}

	@Override
	public Book getBookById(int bId) {
		// TODO Auto-generated method stub
		return brepo.findById(bId).orElseThrow(()-> new BookNotFoundException("book id does Not exist")) ;
	}

	@Override
	public Book updateBookById(Book book, int bId) {
		Book book1=brepo.findById(bId).orElseThrow(() -> new BookNotFoundException("book id does Not exist"));
		
		book1.setDateOfBookGiven(book.getDateOfBookGiven());
		book1.setDateOfBookreturn(book.getDateOfBookreturn());
		brepo.save(book1);
		return book1;
	}

	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		return brepo.findAll();
	}

	@Override
	public void deleteBookById(int bId) {
		
		brepo.findById(bId).orElseThrow(() -> new BookNotFoundException("book id does Not exist"));
		brepo.deleteById(bId);
	}

	
	
	@Override
	public List<Book> getBookByauthorName(String authorName) {
		return brepo.getBookByauthorName(authorName);
	}

	@Override
	public List<Book> getBookByCategory(String bookCategory) {
		// TODO Auto-generated method stub
		return brepo.getBookByCategory(bookCategory);
	}

}
