  package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Book;

//jpa Repository

public interface BookRepository extends JpaRepository<Book, Integer>{

}
