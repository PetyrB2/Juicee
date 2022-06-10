package com.qa.demo.dao;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
	//===================== Imports Above this line
	//===================== Includes Before Class

	//LOMBOK <<<<IMPORTANT
	@Data
	@NoArgsConstructor
	//Entity  <<<<IMPORTANT
	@Entity

	//===================== BEGIN of Class 

	public class Recipe {
		public Recipe(long id, String name, String description, String imgUrl, String howto, List<Ingredients> ingredients) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.howto = howto;
			this.imgUrl = imgUrl;
			this.ingredients = ingredients;
//			this.quantity = quantity;
		}

		// =====================ID IMPORTANT
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)

		// ATTRIBUTES PRIVATE
		private long id;
		private String name;
		private String description;
		private String howto;
		@Column(name = "img_url")
		private String imgUrl;

		
		// One TO Many Target Recipe.class
		@OneToMany(targetEntity = Ingredients.class, cascade = CascadeType.ALL)
		@JoinColumn(name = "ingredients_id", referencedColumnName = "id" )
		private List<Ingredients> ingredients;

		// Database bit follows - Pay ATTENTION !!!
//
//		@ManyToOne(targetEntity = Quantity.class)
//		@JoinColumn(name = "quantity_id")
//
//		private Quantity quantity;
		// Getters & Setters Taken Care of By @Data (Included in Pom (Lombok
		// (springdoc)))
}