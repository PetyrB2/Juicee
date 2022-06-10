//package com.qa.demo.service;
//
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//import com.qa.demo.dao.Recipe;
//import com.qa.demo.persistence.repo.UserRepo;
//import com.qa.demo.user.Role;
//import com.qa.demo.user.User;
//
//
//@Service
//public class UserService {
//
//	private UserRepo repo;
//	
//
//	public UserService(UserRepo repo) {
//		this.repo = repo;
//	}
//
//	// CRUD FOLLOWS
//	
//	//CREATE
//	public User create(User user) {
//		return this.repo.save(user);
//	}
//	
//	//READ
//	public List<User> readAll() {
//		return this.repo.findAll();
//	}
//	
//	//UPDATE
//	public User update(User User, Long id) throws Exception {
//		User updateFromRepo = this.repo.findById(id).orElseThrow(Exception::new);
//		updateFromRepo.setEmail(User.getEmail());
//		updateFromRepo.setPassword(User.getPassword());
//		updateFromRepo.setFirstName(User.getFirstName());
//		updateFromRepo.setLastName(User.getLastName());
//		return this.repo.saveAndFlush(updateFromRepo);
//	}
//	
//	//DELETE
//	public List<User> delete(Long id) {
//		this.repo.deleteById(id);
//			return this.repo.findAll();
//	}
//}
