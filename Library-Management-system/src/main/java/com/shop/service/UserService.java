package com.shop.service;

import java.util.List;
import com.shop.entity.User;


//All Abstract Method  To Perform CRUD Operation And Using Query
public interface UserService {

	
	//Method for Add User Detail 
	public User AddUser(User user);
	
	//method for update User Detail
	public User updateUserById(User user ,long uId);
	
	//method for fetching User Detail By Id
	public User getUserById(long uId);
	
	//method for fetching All User Detail
	public List<User> fetchAllUser();
	
	//method for delete User Detail
	public void deleteUserById(long uId);
	
	
	//method for fetching All User By user Name 
	List<User> getUserByName(String uName);
	
	//method for fetching All User By user Address
	List<User> getUserByAddress(String uAddress);
	
	//method for fetching  User By user Contact
	User getUserByPhone(Long uPhone);
}
