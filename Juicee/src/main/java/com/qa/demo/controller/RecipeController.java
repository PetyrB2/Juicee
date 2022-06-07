package com.qa.demo.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.dao.Recipe;
import com.qa.demo.service.RecipeService;

@RestController
@CrossOrigin
@RequestMapping("/Recipe")
public class RecipeController {

		private RecipeService service;
		
		public RecipeController(RecipeService service) {
			this.service = service;
		}
		
		
		// ======== CRUD ===========
		
		// CREATE (For Testing in Postman: http://localhost:8085/Juicee/create)
		@PostMapping("/create")
		public ResponseEntity<Recipe> createCar(@RequestBody Recipe Recipe) {
			return new ResponseEntity<>(this.service.create(Recipe), HttpStatus.CREATED);
		}

		// READ (ALL)
		@GetMapping("/read")
		public ResponseEntity<List<Recipe>> read() {
			return new ResponseEntity<>(this.service.readAll(), HttpStatus.OK);

		}
			
//			// UPDATE (by ID)
//			@PutMapping("/update/{id}")
//			public ResponseEntity<Ingredients> update(@PathVariable long id, @RequestBody Ingredients Ingredients) throws Exception {
//				return new ResponseEntity<>(this.service.update(Ingredients), HttpStatus.ACCEPTED);
//			}
	//
//			// DELETE (by ID)
//			@DeleteMapping("/delete/{id}")
//			public ResponseEntity<Boolean> delete(@PathVariable Long id) throws Exception {
//				return new ResponseEntity<>(this.service.delete(id), HttpStatus.NO_CONTENT);
	//
//			}
}