package com.qa.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qa.demo.dao.Ingredients;
import com.qa.demo.service.IngredientsService;

@RestController
@CrossOrigin
@RequestMapping("/Ingredients")
public class IngredientsController {

	private IngredientsService service;
	
	public IngredientsController(IngredientsService service) {
		this.service = service;
	}
	
	
	// ======== CRUD ===========
	
	// CREATE (For Testing in Postman: http://localhost:8085/Ingredients/create)
	@PostMapping("/create")
	public ResponseEntity<Ingredients> create(@RequestBody Ingredients Ingredients) {
		return new ResponseEntity<>(this.service.create(Ingredients), HttpStatus.CREATED);
	}

	// READ (ALL)
		@GetMapping("/read")
		public ResponseEntity<List<Ingredients>> read() {
			return new ResponseEntity<>(this.service.readAll(), HttpStatus.OK);

		}
		
//		// UPDATE (by ID)
//		@PutMapping("/update/{id}")
//		public ResponseEntity<Ingredients> update(@PathVariable long id, @RequestBody Ingredients Ingredients) throws Exception {
//			return new ResponseEntity<>(this.service.update(Ingredients), HttpStatus.ACCEPTED);
//		}
//
		// DELETE (by ID)
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<Boolean> delete(@PathVariable Long id) throws Exception {
			return this.service.delete(id) != null ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
					: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
}
