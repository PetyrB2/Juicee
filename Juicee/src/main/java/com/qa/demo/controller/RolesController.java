package com.qa.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qa.demo.persistence.repo.RoleRepo;
import com.qa.demo.service.RoleService;
import com.qa.demo.user.Role;

@CrossOrigin
@Controller
@RequestMapping("/Roles")
public class RolesController {

	@Autowired
	private RoleService service;
	
	public RolesController(RoleService service) {
		this.service = service;
	}
	
	@Autowired
	private RoleRepo repo;

	// ======== CRUD ===========
	
	// CREATE (For Testing in Postman: http://localhost:8080/Roles/create)
	@PostMapping("/create")
	public ResponseEntity<Role> create(@RequestBody Role Role) {
		return new ResponseEntity<>(this.service.create(Role), HttpStatus.CREATED);
	}
	
	// READ (ALL) (For Testing in Postman: http://localhost:8080/Roles/read)
	@GetMapping("/read")
	public ResponseEntity<List<Role>> read() {
		return new ResponseEntity<>(this.service.readAll(), HttpStatus.OK);
	}
	
	// UPDATE
	@PutMapping("/update/{id}")
	public ResponseEntity<Role> update(@PathVariable Long id, @RequestBody Role Role) throws Exception {
		return new ResponseEntity<Role>(this.service.update(Role, id), HttpStatus.ACCEPTED);
	}
	
	
//	// DELETE (by ID)
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) throws Exception {
		return this.service.delete(id) != null ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
}
