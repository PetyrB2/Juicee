package com.qa.demo.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.web.bind.annotation.CrossOrigin;
import lombok.Data;
import lombok.NoArgsConstructor;
//===================== Imports Above this line

//===================== Includes Before Class
//LOMBOK <<<<IMPORTANT
@Data
@NoArgsConstructor
//Entity  <<<<IMPORTANT
@Entity
//Cross Origin needed for JS
@CrossOrigin
//===================== Includes Before Class
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
	
	// X REFERENCE FOR DATABSES - CATEGORY ONE CATEGORY TO MANY INGREDIENTS !
	//======Many to WHO  ( targetEntity = XXXXXX.class ) ?
	@ManyToOne(targetEntity = Category.class)
	// =====The field to link the 2 tables by ==== 
	@JoinColumn(name = "category_id")
	private Category category;

	// Constructor
	public Ingredients(long id, String name, String imgUrl, String description, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.imgUrl = imgUrl;
		this.description = description;
		this.category = category;
	}

	public void setCategory(long category_id, String category_name) {
		// TODO Auto-generated method stub
		
	}

//	@ManyToMany(targetEntity = Quantity.class)
//	@JoinTable(name = "quantity_id", joinColumns = @JoinColumn(name = "quantity_id"))
//	// Foreign Key
//	private Quantity quantity;
	// Getters & Setters Taken Care of By @Data (Included in Pom (Lombok)
	// (springdoc)))
}
