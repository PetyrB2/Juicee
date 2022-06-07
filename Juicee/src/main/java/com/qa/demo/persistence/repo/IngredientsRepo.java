package com.qa.demo.persistence.repo;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.qa.demo.dao.Ingredients;


@Repository
public interface IngredientsRepo extends JpaRepository<Ingredients, Long> {
	
	//SQL
	
		// SQL and build the logic behind the FIND BY NAME ()
		@Query(value = "SELECT * FROM Ingredients WHERE name = ?1", nativeQuery = true)
		public List<Ingredients> findByName(String str);

		// SQL and build the logic behind the FIND BY id ()
		@Query(value = "SELECT * FROM Ingredients WHERE id = ?1", nativeQuery = true)
		public Optional<Ingredients> findById(Long id);


}
