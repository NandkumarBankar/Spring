package com.hbproject;

import java.util.Scanner;

import com.hbproject.daoimpl.CompanyDAOImpl;

public class App 
{
    public static void main( String[] args )
    {
    	 Scanner sc=new Scanner(System.in);

    	System.out.println("-------------------------- Welcome To Global Technogies Pvt Ltd.-----------------------");
    	System.out.println(" Enter 1 For Add Employee Detail \n Enter 2 For Fetch Employee Detail \n Enter 3 For Update Employee Detail"
    			+ "\n Enter 4 For Delete Employee Detail");
    	int key=sc.nextInt(); sc.nextLine();
    		
    	CompanyDAOImpl daoImpl=new CompanyDAOImpl();

    	switch (key) {
		case 1:daoImpl.addCompany();
			break;
		case 2:daoImpl.fetchCompany();
		break;
		case 3:daoImpl.updateCompany();
		break;
		case 4:daoImpl.deleteCompany();
		break;
		default:System.out.println("Enter Default Key");
			break;
		}
    	
    }
}
