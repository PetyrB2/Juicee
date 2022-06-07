package com.qa.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.dao.Category;
import com.qa.demo.persistence.repo.CategoryRepo;
import com.qa.demo.service.CategoryService;

@RestController
@CrossOrigin
@Controller
@RequestMapping("/Category")
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	public CategoryController(CategoryService service) {
		this.service = service;
	}
	@Autowired
	
	private CategoryRepo repo;

	// ======== CRUD ===========
	
	// CREATE (For Testing in Postman: http://localhost:8080/Category/create)
	@PostMapping("/create")
	public ResponseEntity<Category> create(@RequestBody Category Category) {
		return new ResponseEntity<>(this.service.create(Category), HttpStatus.CREATED);
	}
	
	// READ (ALL) (For Testing in Postman: http://localhost:8080/Category/read)
	@GetMapping("/read")
	public ResponseEntity<List<Category>> read() {
		return new ResponseEntity<>(this.service.readAll(), HttpStatus.OK);
	}

	// Save and Redirect
	@PostMapping("/save")
	public String saveCategory(Category category) {
		repo.save(category);
		
		return "redirect:/categories";
	}


//	// UPDATE (by ID)
//	@PutMapping("/update/{id}")
//	public ResponseEntity<Category> update(@PathVariable long id, @RequestBody Category Category) throws Exception {
//		return new ResponseEntity<>(this.service.update(Category), HttpStatus.ACCEPTED);
//	}
//	
//	// DELETE (by ID)
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<Boolean> delete(@PathVariable Long id) throws Exception {
//		return new ResponseEntity<>(this.service.delete(id), HttpStatus.NO_CONTENT);
//
//	}

}
