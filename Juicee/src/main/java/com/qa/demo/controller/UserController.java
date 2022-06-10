package com.qa.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qa.demo.persistence.repo.UserRepo;
import com.qa.demo.service.UserService;
import com.qa.demo.user.User;

@CrossOrigin
@Controller
@RequestMapping("/Users")
public class UserController {

	@Autowired
	private UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	@Autowired
	
	private UserRepo repo;

		// ======== CRUD ===========
		
		// CREATE (For Testing in Postman: http://localhost:8080/Users/create)
		@PostMapping("/create")
		public ResponseEntity<User> create(@RequestBody User User) {
			return new ResponseEntity<>(this.service.create(User), HttpStatus.CREATED);
		}
		
		// READ (ALL) (For Testing in Postman: http://localhost:8080/Users/read)
		@GetMapping("/read")
		public ResponseEntity<List<User>> read() {
			return new ResponseEntity<>(this.service.readAll(), HttpStatus.OK);
		}
		
//		// UPDATE (by ID)
		@PutMapping("/update/{id}")
		public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User User) throws Exception {
			return new ResponseEntity<User>(this.service.update(User, id), HttpStatus.ACCEPTED);
		}
		
//		// DELETE (by ID)
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<Boolean> delete(@PathVariable Long id) throws Exception {
			return this.service.delete(id) != null ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
					: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
		
		// Other Mapping
		@GetMapping("/")
		public String homeRoot() {
			return "index.html";
		}
		
		@GetMapping("/home")
		public String home() {
			return "index.html";
		}
		
		@GetMapping("/register")
		public String showRegister(Model model) {
			model.addAttribute("user", new User());
			return "register.html";
		}
		@PostMapping("/process_register")
		public String processReg(User user) {
			repo.save(user);
			
			return "success.html";
		}
}
