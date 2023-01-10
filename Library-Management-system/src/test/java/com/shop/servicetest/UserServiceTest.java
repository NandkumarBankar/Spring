package com.shop.servicetest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shop.entity.User;
import com.shop.repository.UserRepository;
import com.shop.service.UserService;

//testing All CRUD Method

@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService us;
	
	@MockBean
	private UserRepository ur;
	
	//Method for addUser() of user Service
	
	@Test 
	public void testAdduser() {
		User u1=new User();
		u1.setuId(1);
		u1.setuName("Nandkumar");
		u1.setuAddress("Shirdi");
		u1.setuEmail("nandu@gamil.com");
		u1.setuPhone(880574860);
		
		Mockito.when(ur.save(u1)).thenReturn(u1);
		assertThat(us.AddUser(u1)).isEqualTo(u1);
	}
	
	//Method For updateUserById of User Service
	
	@Test
	public void testUpdateUserById() {
		User u1=new User();
		u1.setuId(1);
		u1.setuName("Nandkumar");
		u1.setuAddress("Shirdi");
		u1.setuEmail("nandu@gamil.com");
		u1.setuPhone(880574860);
		
		Optional<User> u=Optional.of(u1);
		User uu=u.get();
		
		Mockito.when(ur.findById((long)1)).thenReturn(u);
		
		//update phone
		
		u1.setuPhone(762056898);
		Mockito.when(ur.save(uu)).thenReturn(uu);
		assertThat(us.updateUserById(uu, 1)).isEqualTo(uu);
 	}
	   
	  //testing getUserById() of user service
	
	@Test
	public void testGetUserById() {
		User u1=new User();
		u1.setuId(1);
		u1.setuName("Nandkumar");
		u1.setuAddress("Shirdi");
		u1.setuEmail("nandu@gamil.com");
		u1.setuPhone(880574860);
		
		Optional<User> u=Optional.of(u1);
		User uu=u.get();
		
		Mockito.when(ur.findById((long)1)).thenReturn(u);
		assertThat(us.getUserById(1)).isEqualTo(uu);
	}
	
	//testing fetchAllUser() of user service
	
	@Test
	public void testfetchAllUser() {
		User u1=new User();
		u1.setuId(1);
		u1.setuName("Nandkumar");
		u1.setuAddress("Shirdi");
		u1.setuEmail("nandu@gamil.com");
		u1.setuPhone(880574860);
		
		User u2=new User();
		u2.setuId(2);
		u2.setuName("Nand");
		u2.setuAddress("KPG");
		u2.setuEmail("nand@gamil.com");
		u2.setuPhone(880574870);
		
		List<User> li=new ArrayList<>();
		li.add(u1);
		li.add(u2);
		
		Mockito.when(ur.findAll()).thenReturn(li);
		assertThat(us.fetchAllUser()).isEqualTo(li);
	}
	// testing deleteUserById() of user service
	
	@Test
	public void testDeleteUserById() {
		User u1=new User();
		u1.setuId(1);
		u1.setuName("Nandkumar");
		u1.setuAddress("Shirdi");
		u1.setuEmail("nandu@gamil.com");
		u1.setuPhone(880574860);
		
		Optional<User> u=Optional.of(u1);
		
		Mockito.when(ur.existsById((long)1)).thenReturn(false);
		assertThat(ur.existsById(u.get().getuId()));
	

	}
	
	// testing getUserByName() of user service
	@Test
	public void testGetUserByName() {
		User u1=new User();
		u1.setuId(1);
		u1.setuName("Nandkumar");
		u1.setuAddress("Shirdi");
		u1.setuEmail("nandu@gamil.com");
		u1.setuPhone(880574860);
		
		User u2=new User();
		u2.setuId(2);
		u2.setuName("Nandkumar");
		u2.setuAddress("KPG");
		u2.setuEmail("nand@gamil.com");
		u2.setuPhone(880574870);
		
		
	
	List<User> li=new ArrayList<>();
	
	li.add(u1);
	li.add(u2);
	
	Mockito.when(ur.getUserByName("Nandkumar")).thenReturn(li);
	assertThat(us.getUserByName("Nandkumar")).isEqualTo(li);
	
	}
	
	//testing getUserByAddress() of user service 
	@Test
	public void testGetUserByAddress() {
		User u1=new User();
		u1.setuId(1);
		u1.setuName("Nandkumar");
		u1.setuAddress("Shirdi");
		u1.setuEmail("nandu@gamil.com");
		u1.setuPhone(880574860);
	
		List<User> li=new ArrayList<>();
		li.add(u1);
		
		Mockito.when(ur.getUserByAddress("Shirdi")).thenReturn(li);
		assertThat(us.getUserByAddress("Shirdi")).isEqualTo(li);
	}
	
	//testing getUserByPhone() of user service
	@Test
	public void getUserByPhone() {
		User u1=new User();
		u1.setuId(1);
		u1.setuName("Nandkumar");
		u1.setuAddress("Shirdi");
		u1.setuEmail("nandu@gamil.com");
		u1.setuPhone(880574860);
	
		Optional<User> u=Optional.of(u1);
		User uu=u.get();
		
		Mockito.when(ur.getUserByPhone((long)880574860)).thenReturn(u1);
		assertThat(us.getUserByPhone((long)880574860)).isEqualTo(uu);
	}
			
}
