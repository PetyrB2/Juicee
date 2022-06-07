package com.qa.demo.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
//===================== Imports Above this line

//===================== Includes Before Class
//LOMBOK <<<<IMPORTANT
@Data
@NoArgsConstructor
//Entity  <<<<IMPORTANT
@Entity

// ===================== BEGIN of Class

public class Ingredients {

	// ATTRIBUTES PRIVATE
	// =====================ID IMPORTANT
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 30, nullable = false, unique = true)
	private String name;
	private String description;
	@Column(nullable = false)
	private String imgUrl;
	
	// X REFERENCE FOR DATABSES - CATEGORY !
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	// Constructor
	public Ingredients(long id, String name, String imgUrl, String description) {
		super();
		this.id = id;
		this.name = name;
		this.imgUrl = imgUrl;
		this.description = description;
	}

	// Getters & Setters Taken Care of By @Data (Included in Pom (Lombok)
	// (springdoc)))
}
