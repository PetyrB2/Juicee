//package com.qa.demo.persistence.repo;
//
//	import static org.assertj.core.api.Assertions.assertThat;
//
//import org.apache.catalina.User;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.Rollback;
//
//import com.qa.demo.user.Role;
//
//	@DataJpaTest
//	//To use the real database as opposed to in memory database for creation purposes.
//	@AutoConfigureTestDatabase(replace = Replace.NONE)
//	@Rollback(false)
//
//	public class RolesRepoTests {
//
//
//		@Autowired
//		private RoleRepo repo;
//
//		@Autowired
//		private TestEntityManager entityManager;
//
////		// Test used for Creation of database & fields 
//			@Test
//		public void testCreateRole() {
//				Role role = new Role();
//				role.setName("Administrator");
//				//save the user using crudrepository
//				Role savedRole = repo.save(role);
//				
//				Role existRole = entityManager.find(Role.class, savedRole.getId());
//				
//				//Assertion by Email verification
//				assertThat(existRole.getName()).isEqualTo(role.getName());
//		}
//		
//		public void testUserAssertId() {
//
//			// save the user using crud repository
//			Role savedUser = repo.save(new Role("User"));
//
//			// Assertion by id not 0
//			assertThat(savedUser.getId()).isGreaterThan(0);
//		}
//		
////		//TEST TO CREATE ROLES
//		@Test
//		public void testCreateRoles() {
//			Role roleAdmin = new Role("Administrator");
//			Role roleSupervisor = new Role("Supervisor");
//			Role roleVisitor = new Role("Visitor");
//		}
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