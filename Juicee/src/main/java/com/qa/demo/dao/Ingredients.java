package com.qa.demo.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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

	// =====================ID IMPORTANT
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	// ATTRIBUTES PRIVATE
	private long id;
	private String name;
	private String description;
	private String imgUrl;

	// Constructor
	public Ingredients(long id, String name, String imgUrl, String description) {
		super();
		this.id = id;
		this.name = name;
		this.imgUrl = imgUrl;
		this.description = description;
	}

//		@OneToMany(mappedBy = "ingredients")
//		@OnDelete(action = OnDeleteAction.CASCADE)
//		private List<Recipe> recipes = new ArrayList<>();

	// Many to One Target Recipe.class
//		@ManyToOne(targetEntity = Recipe.class)
//		private Recipe Recipe;

	// Getters & Setters Taken Care of By @Data (Included in Pom (Lombok)
	// (springdoc)))
}
