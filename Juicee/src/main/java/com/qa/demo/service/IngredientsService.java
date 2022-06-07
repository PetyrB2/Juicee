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

	
	public List<Ingredients> readAll() {
		return this.repo.findAll();
	}
	
	public Ingredients create(Ingredients ingredients) {
		return this.repo.save(ingredients);
	}

	public Ingredients update(Ingredients ingredients) {
		//SOME UPDATE STUFF HERE
		return this.repo.save(ingredients);
	}
}
