//package com.qa.demo.persistence.repo;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
////import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.Rollback;
//
//import com.qa.demo.dao.Quantity;
//
//	@DataJpaTest
//	//To use the real database as opposed to in memory database for creation purposes.
//	@AutoConfigureTestDatabase(replace = Replace.NONE)
//	@Rollback(false)
//
//	public class QuantityRepoTests {
//
//
//		@Autowired
//		private QuantityRepo repo;
//
////		@Autowired
////		private TestEntityManager entityManager;
//
////		// Test used for Creation of database & fields 
////			@Test
////		public void testCreateQuantity() {
////				Quantity quantity = new Quantity();
////				quantity.setQuantity(4L);
////				//save the user using crudrepository
////				Role savedQuantity = repo.save(quantity);
////				
////				Role existQuantity = entityManager.find(Quantity.class, savedQuantity.getId());
////				
////				//Assertion by Email verification
////				assertThat(existQuantity.getName()).isEqualTo(quantity.getQuantity());
////		}
//		
//		public void testQuantityAssertId() {
//
//			// save the user using crud repository
//			Quantity savedQuantity = repo.save(new Quantity(5L));
//
//			// Assertion by id not 0
//			assertThat(savedQuantity.getId()).isGreaterThan(0);
//		}
//		
//		
//		// TEST TO SET ROLE TO USER
////		@Test
////		public void testAssignRole() {
////			User user = repo.findById(1).get();
////			Role roleVisitor = entityManager.find(Role.class, 2)
////					user.addRole(roleVisitor);
////		}
//		
//		
//		
//	}