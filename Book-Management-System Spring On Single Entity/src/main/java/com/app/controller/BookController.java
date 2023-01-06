package com.app.controller;

import java.util.List;

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

import com.app.entity.Book;
import com.app.service.BookService;

import jakarta.validation.Valid;

@RestController
public class BookController {

	@Autowired
	private BookService bs;
	
	@PostMapping("/saveB")
	public ResponseEntity<Book> saveBook(@Valid @RequestBody Book book){
		return new ResponseEntity<Book>(bs.saveBook(book),HttpStatus.CREATED);	
	}
	
	@PutMapping("/updateB/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book ,@PathVariable int id){
		return new ResponseEntity<Book>(bs.updateBookById(book, id),HttpStatus.OK);	
	}
	@DeleteMapping("/deleteB/{id}")
	public  ResponseEntity<String> deleteBook(@PathVariable int id){
		return new ResponseEntity<String>("deleted Succesfully",HttpStatus.OK);		
	}
	@GetMapping("/getB/{id}")
	public ResponseEntity<Book>  fetchByBook(@PathVariable int id){
		return new ResponseEntity<Book>(bs.fetchBookById(id),HttpStatus.OK);
	}
	@GetMapping("/getAll")
	public List<Book> getAallBook(){
		return bs.getAllBooks();
	}
	
}
