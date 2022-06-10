//package com.qa.demo.dao;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import lombok.Data;
//import lombok.NoArgsConstructor;
////===================== Imports Above this line
//
////===================== Includes Before Class
////LOMBOK <<<<IMPORTANT
//@Data
//@NoArgsConstructor
////Entity  <<<<IMPORTANT
//@Entity
////Cross Origin needed for JS
//@CrossOrigin
//@Table(name = "quantity")
//public class Quantity {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	// Attributes
//	private long id;
//	@Column(nullable = false)
//	private long quantity;
//
//	public Quantity(long id) {
//		super();
//		this.id = id;
//	}
//
//	public Quantity(long id, long quantity) {
//		super();
//		this.id = id;
//		this.quantity = quantity;
//	}
//
//	public Quantity(long id, long quantity, Ingredients ingredients, Recipe recipe) {
//		super();
//		this.id = id;
//		this.quantity = quantity;
//		this.ingredients = ingredients;
//		this.recipe = recipe;
//	}
//
//	// Database bit follows - Pay ATTENTION !!!
//
//	@ManyToOne(targetEntity = Recipe.class)
//	@JoinColumn(name = "recipe_id")
//
//	private Recipe recipe;
//
//	@ManyToMany(targetEntity = Ingredients.class)
//	@JoinTable(name = "ingredients_id", joinColumns = @JoinColumn(name = "ingredients_id"))
//	// Foreign Key
//	private Ingredients ingredients;
//
//}
