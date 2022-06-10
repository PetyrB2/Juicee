//package com.qa.demo.service;
//
//import java.util.List;
//import org.springframework.stereotype.Service;
//import com.qa.demo.persistence.repo.RoleRepo;
//import com.qa.demo.user.Role;
//
//@Service
//public class RoleService {
//
//	private RoleRepo repo;
//	
//
//	public RoleService(RoleRepo repo) {
//		this.repo = repo;
//	}
//
//	//CREATE
//	public Role create(Role role) {
//		return this.repo.save(role);
//	}
//	
//	//READ
//	public List<Role> readAll() {
//		return this.repo.findAll();
//	}
//	
//	//UPDATE
//	public Role update(Role Role, Long id) throws Exception {
//		Role updateFromRepo = this.repo.findById(id).orElseThrow(Exception::new);
//		updateFromRepo.setName(Role.getName());
//
//		return this.repo.saveAndFlush(updateFromRepo);
//	}
//	
//	//DELETE
//	public List<Role> delete(Long id) {
//		this.repo.deleteById(id);
//			return this.repo.findAll();
//	}
//}
