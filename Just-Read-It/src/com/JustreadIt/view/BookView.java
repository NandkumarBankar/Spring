package com.JustreadIt.view;
import com.JustreadIt.dao.BookDAO;
import com.JustreadIt.model.*; 
import java.util.*;
import com.JustreadIt.service.*;
public class BookView {
	
static Scanner sc=new Scanner(System.in);

public static  boolean addBook() {
	boolean addResult=false;
	
	System.out.println("Enter book id");
	int bookId=sc.nextInt();
	sc.nextLine();
	System.out.println("Enter book Name");
	String bookName=sc.nextLine();
	System.out.println("Enter Author Name");
	String authorName=sc.nextLine();
	System.out.println("Enter publisher Name");
	String publisherName=sc.nextLine();
	System.out.println("Enter Rental Price");
	double rentalPrice=sc.nextDouble();

	Book bookObj=new Book(bookId,bookName,authorName,publisherName, rentalPrice);
	BookService.addBook(bookObj);
	return addResult;
}
	
public static void displayBook() {
	Book b1=new Book(123 ,"7 Habbits" ,"Nepolene,","XYZ",100);
	Book b2=new Book(123 ,"7 Habbits" ,"Nepolene,","XYZ",100);
      
}
}
