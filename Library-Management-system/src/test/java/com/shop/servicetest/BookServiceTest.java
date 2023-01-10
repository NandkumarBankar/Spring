package com.shop.servicetest;



import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shop.entity.Book;
import com.shop.repository.BookRepository;
import com.shop.service.Bookservice;

import net.bytebuddy.description.ModifierReviewable.OfAbstraction;

   //Test All CRUD Method

@SpringBootTest
public class BookServiceTest {

	@Autowired
	private Bookservice bs;
	
	@MockBean
	private BookRepository br;
	
	//(1) testing addBook () of book service 
	
	@Test
	public void testAddBook() {
		Book b1=new Book();
		b1.setBookId(1);
		b1.setBookName("Wings Of Fire");
		b1.setBookCategory("Inspirational");
		b1.setAuthorName("Dr A.P.J. Kalam");
		b1.setPublishedYear("1999");
		b1.setDateOfBookGiven("27-12-2022");
		b1.setDateOfBookreturn("01-01-2023");
		
		Mockito.when(br.save(b1)).thenReturn(b1);
		assertThat(bs.addBook(b1)).isEqualTo(b1);
	}
	
	//(2) testing getBookById) of book service
	
	@Test
	public void testGetBookById() {
		Book b1=new Book();
		b1.setBookId(1);
		b1.setBookName("Wings Of Fire");
		b1.setBookCategory("Inspirational");
		b1.setAuthorName("Dr A.P.J. Kalam");
		b1.setPublishedYear("1999");
		b1.setDateOfBookGiven("27-12-2022");
		b1.setDateOfBookreturn("01-01-2023");
		
		Optional<Book> b=Optional.of(b1);
		Book ub=b.get();
		
		Mockito.when(br.findById(1)).thenReturn(b);
		assertThat(bs.getBookById(1)).isEqualTo(ub);
	}
	
	//(3) testing updateBookById() of book service
	@Test
	public void testUpdateBookById() {
		Book b1=new Book();
		b1.setBookId(1);
		b1.setBookName("Wings Of Fire");
		b1.setBookCategory("Inspirational");
		b1.setAuthorName("Dr A.P.J. Kalam");
		b1.setPublishedYear("1999");
		b1.setDateOfBookGiven("27-12-2022");
		b1.setDateOfBookreturn("01-01-2023");
		
		Optional<Book> b=Optional.of(b1);
		Book ub=b.get();
		
		Mockito.when(br.findById(1)).thenReturn(b);
		
		//update
		ub.setDateOfBookGiven("30-12-2022");
		ub.setDateOfBookreturn("15-01-2023");
		
		Mockito.when(br.save(ub)).thenReturn(ub);
		assertThat(bs.updateBookById(ub, 1)).isEqualTo(ub);
		
	}
	
	  // (4) testing getAllBook() of book service
	
	@Test
	public void testGetAllBook() {
		Book b1=new Book();
		b1.setBookId(1);
		b1.setBookName("Wings Of Fire");
		b1.setBookCategory("Inspirational");
		b1.setAuthorName("Dr A.P.J. Kalam");
		b1.setPublishedYear("1999");
		b1.setDateOfBookGiven("27-12-2022");
		b1.setDateOfBookreturn("01-01-2023");
	
		Book b2=new Book();
		b2.setBookId(2);
		b2.setBookName("Sambhaji");
		b2.setBookCategory("Historical");
		b2.setAuthorName("v patil");
		b2.setPublishedYear("1989");
		b2.setDateOfBookGiven("27-12-2022");
		b2.setDateOfBookreturn("01-01-2023");
	
		List<Book> li=new ArrayList<>();
		li.add(b1);
		li.add(b2);
		
		Mockito.when(br.findAll()).thenReturn(li);
		assertThat(bs.getAllBook()).isEqualTo(li);
	}
	//(5) testing deleteBookById() of Book service
	
	@Test
	public void testDeleteBookById() {
		Book b1=new Book();
		b1.setBookId(1);
		b1.setBookName("Wings Of Fire");
		b1.setBookCategory("Inspirational");
		b1.setAuthorName("Dr A.P.J. Kalam");
		b1.setPublishedYear("1999");
		b1.setDateOfBookGiven("27-12-2022");
		b1.setDateOfBookreturn("01-01-2023");
	
		Optional<Book> b=Optional.of(b1);
		
		
		Mockito.when(br.existsById(1)).thenReturn(false);
		assertThat(br.existsById(b.get().getBookId()));
		}
 	
	//(6) testing getBookByauthorName () of Book Service
	@Test
	public void testGetBookByAuthorName() {
		Book b1=new Book();
		b1.setBookId(1);
		b1.setBookName("Wings Of Fire");
		b1.setBookCategory("Inspirational");
		b1.setAuthorName("Dr A.P.J. Kalam");
		b1.setPublishedYear("1999");
		b1.setDateOfBookGiven("27-12-2022");
		b1.setDateOfBookreturn("01-01-2023");
	
		List<Book> li=new ArrayList<>();
		li.add(b1);
		
		
		Mockito.when(br.getBookByauthorName("Dr A.P.J. Kalam")).thenReturn(li);
		assertThat(bs.getBookByauthorName("Dr A.P.J. Kalam")).isEqualTo(li);
	}
	//(7) testing getBookByCategory() of book service
	@Test
	public void testGetBookByCategory() {
		Book b1=new Book();
		b1.setBookId(1);
		b1.setBookName("Wings Of Fire");
		b1.setBookCategory("Inspirational");
		b1.setAuthorName("Dr A.P.J. Kalam");
		b1.setPublishedYear("1999");
		b1.setDateOfBookGiven("27-12-2022");
		b1.setDateOfBookreturn("01-01-2023");
	
		List<Book> li=new ArrayList<>();
		li.add(b1);
		
		
		Mockito.when(br.getBookByCategory("Inspirational")).thenReturn(li);
		assertThat(bs.getBookByCategory("Inspirational")).isEqualTo(li);
	
	
	}
}