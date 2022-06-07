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

	
	public List<Recipe> readAll() {
		return this.repo.findAll();
	}
	
	public Recipe create(Recipe recipe) {
		return this.repo.save(recipe);
	}

	


}
