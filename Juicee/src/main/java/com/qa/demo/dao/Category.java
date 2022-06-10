package com.qa.demo.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.Data;


@CrossOrigin
@Data
@Entity
public class Category {
	
	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 45, nullable = false, unique = true)
	private String name;

	// blank constructor
	public Category() {
		}
	
	// Constructor for ID
	public Category(long id) {
		super();
		this.id = id;
	}
	
	// Constructor for Name
	public Category(String name) {
		super();
		this.name = name;
	}
	
	// Constructor with id and name
		public Category(long id, String name) {
			}
}
