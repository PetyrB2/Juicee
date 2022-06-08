package com.qa.demo.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	//===================== BEGIN of Class 

	public class Recipe {
		public Recipe(long id, String name, String description, String imgUrl, String howto, Ingredients ingredients) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.howto = howto;
			this.imgUrl = imgUrl;
			this.ingredients = ingredients;
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

		
		// Many to One Target Recipe.class
		@ManyToOne(targetEntity = Ingredients.class)
		private Ingredients ingredients;

		// Getters & Setters Taken Care of By @Data (Included in Pom (Lombok
		// (springdoc)))
}

	////		@ManyToOne(targetEntity = Ingredient.class)
////		@JsonBackReference
////		private Ingredient ingredient;
	// Many to One Target Driver.class
//	@ManyToOne(targetEntity = Driver.class)
//	private Driver driver;
//}
