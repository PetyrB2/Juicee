//package com.qa.demo.persistence.repo;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.Rollback;
//
//import com.qa.demo.dao.Category;
//import com.qa.demo.user.User;
//
//@DataJpaTest
////To use the real database as opposed to in memory database for creation purposes.
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//@Rollback(false)
//
//public class UserRepoTests {
//
//
//	@Autowired
//	private UserRepo repo;
//
//	@Autowired
//	private TestEntityManager entityManager;
//
////	// Test used for Creation of database & fields 
//		@Test
//	public void testCreateUser() {
//		User user = new User();
//			user.setEmail("JavaCoder@mars.com");
//			user.setPassword("password123");
//			user.setFirstName("Java");
//			user.setLastName("IsCool");
//			//save the user using crudrepository
//			User savedUser = repo.save(user);
//			
//			User existUser = entityManager.find(User.class, savedUser.getId());
//			
//			//Assertion by Email verification
//			assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
//	}
//	
////	public void testUserAssertId() {
////
////		// save the user using crud repository
////		User savedUser = repo.save(new User("bob@bob.com", "123123123", "Bob", "Bobboski", "Administrator"));
////
////		// Assertion by id not 0
////		assertThat(savedUser.getId()).isGreaterThan(0);
////	}
//
//	
//}
//
//
//
//
//
//
//
//
//
