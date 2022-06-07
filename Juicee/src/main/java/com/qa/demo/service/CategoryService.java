package com.qa.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.demo.dao.Category;
import com.qa.demo.persistence.repo.CategoryRepo;

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
	// YO deee UPDATE
	public List<Category> update() {
	// add here
		return this.repo.findAll();
	}
	// DELETE
	public List<Category> delete(Long id) {
		this.repo.deleteById(id);
			return this.repo.findAll();
	}
// OHER STUFF#
}
