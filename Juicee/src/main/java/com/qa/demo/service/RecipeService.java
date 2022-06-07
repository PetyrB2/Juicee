package com.qa.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.qa.demo.dao.Recipe;
import com.qa.demo.persistence.repo.RecipeRepo;

@Service
public class RecipeService {

	private RecipeRepo repo;
	

	public RecipeService(RecipeRepo repo) {
		this.repo = repo;
	}

	// CRUD FOLLOWS
	// CREATE
	public Recipe create(Recipe recipe) {
		return this.repo.save(recipe);
	}
	// READ
	public List<Recipe> readAll() {
		return this.repo.findAll();
	}
	
	// UPDATE
	public Recipe update(Recipe Recipe, Long id) throws Exception {
		Recipe updateFromRepo = this.repo.findById(id).orElseThrow(Exception::new);
		updateFromRepo.setName(Recipe.getName());
		updateFromRepo.setDescription(Recipe.getDescription());
		updateFromRepo.setImgUrl(Recipe.getImgUrl());
		
		return this.repo.saveAndFlush(updateFromRepo);
	}

	// DELETE
	public List<Recipe> delete(Long id) {
		this.repo.deleteById(id);
			return this.repo.findAll();
	}
	


}
