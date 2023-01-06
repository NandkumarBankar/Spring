package com.JustreadIt.dao;
import com.JustreadIt.service.*;
import com.JustreadIt.model.*;

import com.JustreadIt.model.Book;

public class BookDAO {
	private static Book bookArray[]=new Book[100];

	public static boolean addBook(Book bookobj) {
	boolean result=false;
	
		for(int i=0;i<bookArray.length;i++) {
			if(bookArray[i]==null) {
				bookArray[i]=bookobj;
				result=true;
				break;
			}
		}
		System.out.println(bookArray[0]);
	return result;
}
}