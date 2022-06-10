//package com.qa.demo.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import com.qa.demo.dao.Quantity;
//import com.qa.demo.persistence.repo.QuantityRepo;
//import com.qa.demo.service.QuantityService;
//
//@CrossOrigin
//@Controller
//@RequestMapping("/Quantity")
//public class QuantityController {
//
//	@Autowired
//	private QuantityService service;
//	
//	public QuantityController(QuantityService service) {
//		this.service = service;
//	}
//	
//	@Autowired
//	private QuantityRepo repo;
//
//	// ======== CRUD ===========
//	
//	// CREATE (For Testing in Postman: http://localhost:8080/Quantity/create)
//	@PostMapping("/create")
//	public ResponseEntity<Quantity> create(@RequestBody Quantity Quantity) {
//		return new ResponseEntity<>(this.service.create(Quantity), HttpStatus.CREATED);
//	}
//	
//	// READ (ALL) (For Testing in Postman: http://localhost:8080/Quantity/read)
//	@GetMapping("/read")
//	public ResponseEntity<List<Quantity>> read() {
//		return new ResponseEntity<>(this.service.readAll(), HttpStatus.OK);
//	}
//	
//	// UPDATE
//	@PutMapping("/update/{id}")
//	public ResponseEntity<Quantity> update(@PathVariable Long id, @RequestBody Quantity Quantity) throws Exception {
//		return new ResponseEntity<Quantity>(this.service.update(Quantity, id), HttpStatus.ACCEPTED);
//	}
//	
//	
////	// DELETE (by ID)
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<Boolean> delete(@PathVariable Long id) throws Exception {
//		return this.service.delete(id) != null ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
//				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//
//	}
//	
//}
