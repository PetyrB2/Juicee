package com.qa.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.demo.dao.Category;
import com.qa.demo.persistence.repo.CategoryRepo;
import com.qa.demo.user.Role;

@Service
public class CategoryService {

	
private CategoryRepo repo;
	
// ###### GET THE REPO UP
	public CategoryService(CategoryRepo repo) {
		this.repo = repo;
	}

	
	// ######### CRUD FOLLOWS #########
	
	// CREATE
	public Category create(Category Category) {
		return this.repo.save(Category);
	}
	// READ
	public List<Category> readAll() {
		return this.repo.findAll();
	}
	//UPDATE
	public Category update(Category Category, Long id) throws Exception {
		Category updateFromRepo = this.repo.findById(id).orElseThrow(Exception::new);
		updateFromRepo.setName(Category.getName());

		return this.repo.saveAndFlush(updateFromRepo);
	}
	
	//DELETE
	public List<Category> delete(Long id) {
		this.repo.deleteById(id);
			return this.repo.findAll();
	}
}
