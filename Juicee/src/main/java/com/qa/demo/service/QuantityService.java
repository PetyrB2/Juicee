//package com.qa.demo.service;
//
//import java.util.List;
//import org.springframework.stereotype.Service;
//import com.qa.demo.dao.Quantity;
//import com.qa.demo.persistence.repo.QuantityRepo;
//
//@Service
//public class QuantityService {
//
//	private QuantityRepo repo;
//	
//
//	public QuantityService(QuantityRepo repo) {
//		this.repo = repo;
//	}
//
//	//CREATE
//	public Quantity create(Quantity role) {
//		return this.repo.save(role);
//	}
//	
//	//READ
//	public List<Quantity> readAll() {
//		return this.repo.findAll();
//	}
//	
//	//UPDATE
//	public Quantity update(Quantity Quantity, Long id) throws Exception {
//		Quantity updateFromRepo = this.repo.findById(id).orElseThrow(Exception::new);
//		updateFromRepo.setQuantity(Quantity.getQuantity());
//
//		return this.repo.saveAndFlush(updateFromRepo);
//	}
//	
//	//DELETE
//	public List<Quantity> delete(Long id) {
//		this.repo.deleteById(id);
//			return this.repo.findAll();
//	}
//}
