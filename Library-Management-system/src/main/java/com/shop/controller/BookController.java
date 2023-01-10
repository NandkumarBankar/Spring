package com.shop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.entity.Book;
import com.shop.service.Bookservice;

@RestController     //rest controller to handle all incoming request using rest API
public class BookController {

	@Autowired
	Bookservice bs;
	
	
	//save Book details using post mapping
	@PostMapping("/addBook")
	public ResponseEntity<Book> addBook(@Valid @RequestBody Book book){
		return new ResponseEntity<Book>(bs.addBook(book),HttpStatus.CREATED);
		
	}
	//update Book details by id using put mapping..
	@PutMapping("/updateBook/{bId}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book , @PathVariable("bId") int bId){
		return new ResponseEntity<Book>(bs.updateBookById(book, bId),HttpStatus.OK);
		
	}
	//fetching Book details by id using get mapping..
	@GetMapping("/getBook/{bId}")
	public ResponseEntity<Book> getBookById(@PathVariable("bId") int bId){
		return new ResponseEntity<Book>(bs.getBookById(bId),HttpStatus.OK);
	}
	//fetching All Book details using get mapping.
	@GetMapping("/getAllBook")
	public List<Book> getAllBook(){
		return bs.getAllBook();
		
	}
	//Delete Book details by id using delete mapping..
	@DeleteMapping("/deleteBook/{bId}")
	public ResponseEntity<String> deleteBookById(@PathVariable("bId") int bId){
		bs.deleteBookById(bId);
		 return new  ResponseEntity<String>("Data Deleted Succesfully",HttpStatus.OK);
		
	}
	//fetching Book details by Author Name using get mapping..
	@GetMapping("/getBookByauthor/{authorName}")
	public List<Book> getBookByAuthorName(@PathVariable("authorName") String authorName){
		return bs.getBookByauthorName(authorName);
		
	}
	//fetching Book details by Category using get mapping..
	@GetMapping("/getBookByCategory/{bookCategory}")
	public List<Book> getBookByCategory(@PathVariable("bookCategory") String bookCategory){
		return bs.getBookByCategory(bookCategory);
		
	}
	
}
