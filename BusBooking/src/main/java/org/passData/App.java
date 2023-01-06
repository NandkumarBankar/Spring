package org.passData;

import java.util.Scanner;

import org.passData.daoimpl.passDataDAOImpl;




public class App {
	static Scanner sc=new Scanner(System.in);

    public static void main( String[] args ) {
    	  passDataDAOImpl pd=new  passDataDAOImpl();
    	    
 
     	 System.out.println("----------Passenger Data----------");
     	 System.out.println("      Enter Your Choice");
     	 System.out.println("       1.Read \n       2.Add \n       3.Update \n       4.Delete \n       5.Exit");
     	 int ch=sc.nextInt();
     	 switch (ch) {
 		case 1:pd.getPasseData();
 		break;
 		
 		case 2:pd.addPassData();
 		break;
 			
 		case 3:pd.updatePassData();
 		break;
 			
 		case 4:pd.deletePassData();
 		break;
 			
 		case 5:System.exit(5);
 		break;
 		
 		default :System.out.println("Invalied Entry");

     	 }    
      }
    
    
}
