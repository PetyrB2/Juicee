package com.qa.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		
		@Autowired
		public RecipeController(RecipeService service) {
			this.service = service;
		}
		
		
		// ======== CRUD ===========
		
		// CREATE (For Testing in Postman: http://localhost:8080/Juicee/create)
		@PostMapping("/create")
		public ResponseEntity<Recipe> createCar(@RequestBody Recipe Recipe) {
			return new ResponseEntity<>(this.service.create(Recipe), HttpStatus.CREATED);
		}

		// READ (ALL)
		@GetMapping("/read")
		public ResponseEntity<List<Recipe>> read() {
			return new ResponseEntity<>(this.service.readAll(), HttpStatus.OK);

		}
			
		// UPDATE
		@PutMapping("/update/{id}")
		public ResponseEntity<Recipe> update(@PathVariable Long id, @RequestBody Recipe Recipe) throws Exception {
			return new ResponseEntity<Recipe>(this.service.update(Recipe, id), HttpStatus.ACCEPTED);
		}
		
		// DELETE (by ID)
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<Boolean> delete(@PathVariable Long id) throws Exception {
			return this.service.delete(id) != null ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
					: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
}