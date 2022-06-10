package com.qa.demo.persistence.repo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import com.qa.demo.dao.Category;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
//@Rollback(false)
public class CategoryRepoTests {

	@Autowired
	private CategoryRepo repo;

	@Autowired
	private TestEntityManager entityManager;

	// Test used for Creation of database & fields
	// remember we have to set spring.jpa.hibernate.ddl-auto=create to create and back to none
	// afterwards. This test will run only once to create our tables.
	@Test
	public void testCreateCategory() {
		Category category = new Category();
		category.setName("Fruit");
		// save the user using crud repository
		Category savedCategory = repo.save(category);

		Category existCategory = entityManager.find(Category.class, savedCategory.getName());

		// Assertion by Name verification
		assertThat(existCategory.getName()).isEqualTo(category.getName());
	}
//
	@Test
	public void testCategoryAssertId() {

		// save the user using crud repository
		Category savedCategory = repo.save(new Category("A"));

		// Assertion by id not 0
		assertThat(savedCategory.getId()).isGreaterThan(0);
	}
	
	
	
}
