package com.JustreadIt;
import java.util.Scanner;

import com.JustreadIt.view.BookView;
 
    public class Main {
	static Scanner sc=new Scanner(System.in);
	
	static void displaySubMenu() {
		System.out.println("1 Add Book");
		System.out.println("2 Display Book");
		System.out.println(" Enter No 1 or 2");
		int enterNo=sc.nextInt();
		sc.nextLine();
		switch(enterNo) {
		case 1:
			boolean addResult=BookView.addBook();
			if(addResult)
			       System.out.println("Book Addded Succesfull");
			  break;
			  default:
				  System.out.println("Invalid Imformation");
		}
	}

	  public static void main(String[] args) {
		 
		 
		do {
			System.out.println("1.Start App");
			System.out.println("2.Stop App");
			System.out.println("Enter NO : 1 or 2");
			int EnterNo=sc.nextInt();
			
			switch(EnterNo) {
			case 1:
				  System.out.println("Menu");
				  displaySubMenu();
				  break;
			case 2:
				System.exit(0);
				break;
				default:
					System.out.print("Invalid Data");					
			}	
		}
		while(true);
		
	}

}
