package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shop.entity.User;

 //JPA Repository
public interface UserRepository extends JpaRepository<User, Long> {

	//customized query using JPQL
	
	
	@Query("select u from User u where u.uName=?1")
	List<User> getUserByName(String uName);
	
	
	@Query("select u from User u where u.uAddress=?1")
	List<User> getUserByAddress(String uAddress);
	
	@Query("select u from User u where u.uPhone=?1")
	User getUserByPhone(Long uPhone);
	
}
