package com.qa.demo.persistence.repo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.qa.demo.dao.Category;
import com.qa.demo.dao.Ingredients;

@DataJpaTest
//To use the real database as opposed to in memory database for creation purposes.
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

public class IngredientsRepoTests {

	@Autowired
	private void cat( ) {
		Category category;
	}

	@Autowired
	private IngredientsRepo repo;

	@Autowired
	private TestEntityManager entityManager;

	// Test used for Creation of databse & fields 
		@Test
	public void testCreateIngredient() {
			Ingredients Ingredients = new Ingredients();
			Ingredients.setName("Google");
			Ingredients.setDescription("A google Image to link to");
			Ingredients.setImgUrl("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png");
			Ingredients.setCategory(10000L, "Google");
			
			//save the user using crudrepository
			Ingredients savedIngredient = repo.save(Ingredients);
			
			Ingredients existIngredient = entityManager.find(Ingredients.class, savedIngredient.getId());
			
			//Assertion by Email verification
			assertThat(existIngredient.getName()).isEqualTo(Ingredients.getName());
	}
}









