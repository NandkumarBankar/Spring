package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shop.entity.Book;

		//JPA Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	//customize Query using JPQL
	
	
	@Query("select b from Book b where b.bookCategory=?1")
	List<Book> getBookByCategory(String bookCategory);
	
	@Query("select b from Book b where b.authorName=?1")
	List<Book> getBookByauthorName(String authorName);
	
}
