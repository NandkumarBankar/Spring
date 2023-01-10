package com.shop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.User;
import com.shop.exception.UserNotFoundExcception;
import com.shop.repository.UserRepository;
import com.shop.service.UserService;


@Service    //service Class
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository urepo;
	
	@Override
	public User AddUser(User user) {
	return urepo.save(user);
	}

	@Override
	public User updateUserById(User user, long uId) {
		// TODO Auto-generated method stub
		User u1=urepo.findById(uId).orElseThrow(()-> new UserNotFoundExcception("user Id Does Not Exist in System. enter Valied User Id ")) ;
		u1.setuPhone(user.getuPhone());
		urepo.save(u1);
		return u1;
	}
	@Override
	public User getUserById(long uId) {
		return urepo.findById(uId).orElseThrow(()-> new UserNotFoundExcception("user Id Does Not Exist in System.\n enter Valied User Id "))  ;
	}

	@Override
	public List<User> fetchAllUser() {
		return urepo.findAll();
	}

	@Override
	public void deleteUserById(long uId) {
		   urepo.findById(uId).orElseThrow(() -> new UserNotFoundExcception("user Id Does Not Exist in System.\\n enter Valied User Id "));	
		   urepo.deleteById(uId);
	}

	@Override
	public List<User> getUserByName(String uName) {
		// TODO Auto-generated method stub
		return urepo.getUserByName(uName);
	}

	@Override
	public List<User> getUserByAddress(String uAddress) {
		// TODO Auto-generated method stub
		return urepo.getUserByAddress(uAddress);
	}

	@Override
	public User getUserByPhone(Long uPhone) {
		return urepo.getUserByPhone(uPhone);
	}

	
			

}
