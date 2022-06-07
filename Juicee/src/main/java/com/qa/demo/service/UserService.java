package com.qa.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.qa.demo.persistence.repo.UserRepo;
import com.qa.demo.user.User;


@Service
public class UserService {

	private UserRepo repo;
	

	public UserService(UserRepo repo) {
		this.repo = repo;
	}

	//CREATE
	public User create(User user) {
		return this.repo.save(user);
	}
	//READ
	public List<User> readAll() {
		return this.repo.findAll();
	}
	//UPDATE
//	public User update(User user) {
//		//SOME UPDATE STUFF HERE
//		return this.repo.save(user);
//	}
//	//DELETE
//
//	public User delete(Long id) {
//		// SOME DELETE METHOD HERE
//		return null;
//	}
	
	
}
