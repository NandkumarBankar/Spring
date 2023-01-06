package com.hbproject.daoimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hbproject.config.HibernateUtil;
import com.hbproject.dao.CompanyDAO;
import com.hbproject.entity.Company;
import com.hbproject.entity.Employee;

public class CompanyDAOImpl implements CompanyDAO {

	public Scanner sc=new Scanner(System.in);
	
	public void addCompany() {
		try {

			Session session=HibernateUtil.getSessionFactory().openSession();
			 Transaction t=session.beginTransaction();
			  Employee emp=new Employee();
			System.out.println("-----------------Enter Emp Detail Are as Follows--------------------"); 
			System.out.println("Employee Name");
			  String name=sc.nextLine();
			  System.out.println("Employee education");
			  String Edu=sc.nextLine();
			  System.out.println("Employee date Of Joining");
			  String DOJ=sc.nextLine();
			  System.out.println("Employee E-mail");
			  String mail=sc.nextLine();
			  System.out.println("Employee Contact Number");
			  Long phone=sc.nextLong();
			  sc.nextLine();
			  
			  emp.setName(name);
			  emp.seteEdu(Edu);
			  emp.setDOJ(DOJ);
			  emp.setEmail(mail);
			  emp.setPhone(phone);
			  
			  List<Employee> li=new ArrayList<Employee>();
			  li.add(emp);
			  
			  System.out.println("-------------------Enter Department Data are As follows----------------");
			  System.out.println("Use following Department id and name");
			  System.out.println(" Id : 01345 Name : Technical \n Id : 1612 Name : Maintainance \n Id: 2789 Name :Q&A");
			  System.out.println("Department id");
			  int depId=sc.nextInt();
			  sc.nextLine();
			  System.out.println("Department Name");
			  String deptName=sc.nextLine();
			  
			Company com=new Company();
			com.setDeptId(depId);
			com.setDeptName(deptName);
			com.setList(li);
			
			session.save(com);
			  t.commit();
			  System.out.println("Data Added succesfully");
			 
		}
		catch (Exception e) {
			System.out.println(e);
		}
					}

	public void fetchCompany() {
		try {

			Session session=HibernateUtil.getSessionFactory().openSession();
			TypedQuery<Company> query=session.createQuery("from Company");
			
			List<Company> ll=query.getResultList();
			Iterator<Company> itr=ll.iterator();
			
			while(itr.hasNext()) {
				Company company=itr.next();
				System.out.println( "Department Id : "+company.getDeptId() +"\nDepartMent Name :" +company.getDeptName() );
				
				List<Employee> li=company.getList();
				Iterator<Employee> itr1=li.iterator();
				while(itr1.hasNext()) {
					Employee emp=itr1.next();
					
					System.out.println("Employee Id :" +emp.getId() + "\nEmployee Name : "+ emp.getName() + "\nEmployee phone :" +emp.getPhone()+"\nEmployee education : "+emp.geteEdu()+"\nEmployee Date Of Joining" +emp.getDOJ()+"\nEmployee Email:"+emp.getEmail());
				}
			}
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
				
	}

	public void updateCompany() {
		try {

			Session session=HibernateUtil.getSessionFactory().openSession();
			 Transaction t=session.beginTransaction();
			 
			 System.out.println("Enter Your Employee Id");
				int id=sc.nextInt();
				sc.nextLine();
				Employee emp=session.get(Employee.class, id);
				System.out.println("Enter Phone Number ");
				Long number=sc.nextLong();
				emp.setPhone(number);
				session.update(emp);
				t.commit();
				System.out.println("-----------Updated Succesfully------------");
			

		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}

	public void deleteCompany() {
		try {
			Session session=HibernateUtil.getSessionFactory().openSession();
			 Transaction t=session.beginTransaction();
			 
		    System.out.println("Enter Your Customer Id");
			int id=sc.nextInt();
			sc.nextLine();
			Employee emp=session.get(Employee.class, id);
			session.delete(emp);
		
			t.commit();
			System.out.println("-----------Deleted Succesfully------------");
		} catch (Exception e) {
			System.out.println(e);
				
			}		
			
	}
	}
