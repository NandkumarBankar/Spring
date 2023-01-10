package com.shop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.entity.User;
import com.shop.service.UserService;

@RestController               //rest controller to handle all incoming request using rest API
public class UserController {

	@Autowired
	 UserService us;
	
	//save User details using post mapping
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody @Valid User user){
		return new ResponseEntity<User>(us.AddUser(user),HttpStatus.CREATED);
		
	}
	//update User details by id using Put mapping..
	@PutMapping("/updateUser/{uId}")
	public  ResponseEntity<User> updateUser(@RequestBody User user ,@PathVariable("uId")  Long uId){
		return new ResponseEntity<User>(us.updateUserById(user, uId),HttpStatus.OK);
		
	}
	//fetching User details by id using get mapping..
	@GetMapping("/getUser/{uId}")
	public ResponseEntity<User> getUserById(@PathVariable("uId") Long uId){
		return new ResponseEntity<User>(us.getUserById(uId),HttpStatus.OK);
		
	}
	//fetching All User details  using get mapping..
	@GetMapping("/getAllUser")
	public List<User> getAllUser(){
		return us.fetchAllUser();
		
	}
	//fetching User details by Name using get mapping..
	@GetMapping("/getAllUserByName/{uName}")
	public List<User> getUserByName(@PathVariable("uName") String uName){
		return us.getUserByName(uName);
	}
	//fetching User details by Address using get mapping..
	@GetMapping("/getAllUserByAddress/{uAddress}")
	public List<User> getUserByAddress(@PathVariable("uAddress") String uAddress){
		return us.getUserByAddress(uAddress);
	}
	//fetching User details by phone using get mapping..
	@GetMapping("/getAllUserByPhone/{uPhone}")
	public ResponseEntity<User> getUserBYPhone(@PathVariable("uPhone") Long uPhone){
		return new ResponseEntity<User>(us.getUserByPhone(uPhone),HttpStatus.OK);
	}
	//Delete User details by id using delete mapping..
	@DeleteMapping("deleteUser/{uId}")
	public ResponseEntity<String> deleteUserById(@PathVariable("uId") Long uId){
		  us.deleteUserById(uId);
		return new ResponseEntity<String>("User data Deleted Succesfully",HttpStatus.OK);
	}
	
}
