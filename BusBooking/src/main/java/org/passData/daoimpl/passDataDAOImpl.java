package org.passData.daoimpl;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.ObjectDeletedException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.passData.Entity.PassengerData;
import org.passData.config.HibernateUtil;
import org.passData.dao.passDataDAO;

import lombok.Data;



public class passDataDAOImpl implements passDataDAO {
	
	public Scanner sc=new Scanner(System.in);
			
	public void getPasseData() {
				
		try {
			Session ses=HibernateUtil.getSessionFactory().openSession();
			Transaction t=ses.beginTransaction();
		
			System.out.println("Enter Passenger Id For Getting Imformation");
			int id=sc.nextInt();
			sc.nextLine();
			PassengerData pd=ses.get(PassengerData.class, id);
			
			System.out.println("passenger Name :"+ pd.getName() + "\nPassenger Contact : "+pd.getContactNo()
			                   + "\nPassenger Gender :" + pd.getGender() + "\nDestination From :"
					+ pd.getDestinationFrom() + "\nDestination Up TO : "+ pd.getDesinationUpTo());
			
			
		} catch (HibernateException e) {
			System.out.println(e);		}
	}

	public void addPassData() {
			
		try {
			Session ses=HibernateUtil.getSessionFactory().openSession();
			Transaction t=ses.beginTransaction();
			
			System.out.println("------------Add Passenger Data--------------------");
			System.out.println("Enter Passengger Name");
			String pName=sc.nextLine();
			System.out.println("Enter Passenger Gender");
			String gen=sc.nextLine();
			System.out.println("Enter Contact Number");
			long contact=sc.nextLong();
			sc.nextLine();
			System.out.println("Enter Destination From");
			String from=sc.nextLine();
			System.out.println("Enter Destination UP To");
			String upto=sc.nextLine();
			
			PassengerData pd=new PassengerData();
			pd.setName(pName);
			pd.setGender(gen);
			pd.setContactNo(contact);
			pd.setDestinationFrom(from);
			pd.setDesinationUpTo(upto);
			
			ses.save(pd);
			t.commit();
			System.out.println("-------------Data added SucssesFully--------------");

			
		} catch (HibernateException e) {
			System.out.println(e);	
			}

	}

	public void updatePassData() {
				
		try {
			Session ses=HibernateUtil.getSessionFactory().openSession();
			Transaction t=ses.beginTransaction();
			
			System.out.println("---------------------Update Data-------------------------\n");
			
			System.out.println("Enter Passenger Id");
			int id=sc.nextInt();
			PassengerData pd=ses.get(PassengerData.class, id);
			System.out.println("-----------------Update Passenger Contact---------------------");
			long contact=sc.nextLong();
			
			pd.setContactNo(contact);
			
			ses.update(pd);
			t.commit();
			System.out.println("-------------Data Updated SucssesFully--------------");

		} catch (HibernateException e) {
			System.out.println(e);	
			}
	}

	public void deletePassData() {
		try {
			Session ses=HibernateUtil.getSessionFactory().openSession();
			Transaction t=ses.beginTransaction();
			
			System.out.println("---------------------Delete Data-------------------------\n");
			
			System.out.println("Enter Passenger Id");
			int id=sc.nextInt();
			PassengerData pd=ses.get(PassengerData.class, id);
			ses.delete(pd);
			t.commit();
			
			System.out.println("-------------Data Deleted SucssesFully--------------");
			
			
		} catch (HibernateException e) {
			System.out.println(e);	
			}
	}

	
	
}
