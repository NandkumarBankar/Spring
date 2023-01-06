package com.JustreadIt.service;
import com.JustreadIt.dao.BookDAO;
import com.JustreadIt.model.*;
import com.JustreadIt.view.*;

public class BookService {

	public static boolean addBook(Book bookobj) {
		boolean result=false;
		BookDAO.addBook(bookobj);
	    return result;
	}
}
