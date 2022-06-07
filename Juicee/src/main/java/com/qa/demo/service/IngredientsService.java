package com.qa.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.qa.demo.dao.Ingredients;
import com.qa.demo.persistence.repo.IngredientsRepo;

@Service
public class IngredientsService {

	private IngredientsRepo repo;
	

	public IngredientsService(IngredientsRepo repo) {
		this.repo = repo;
	}

	// CRUD FOLLOWS
	
	// CREATE
	public Ingredients create(Ingredients ingredients) {
		return this.repo.save(ingredients);
	}

	// READ
	public List<Ingredients> readAll() {
		return this.repo.findAll();
	}
	
	// UPDATE
	public Ingredients update(Ingredients Ingredients, Long id) throws Exception {
		Ingredients updateFromRepo = this.repo.findById(id).orElseThrow(Exception::new);
		updateFromRepo.setName(Ingredients.getName());
		updateFromRepo.setDescription(Ingredients.getDescription());
		updateFromRepo.setImgUrl(Ingredients.getImgUrl());

		return this.repo.saveAndFlush(updateFromRepo);
	}
	
	// DELETE
	public List<Ingredients> delete(Long id) {
		this.repo.deleteById(id);
			return this.repo.findAll();
	}
	
}
