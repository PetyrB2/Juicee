package com.qa.demo.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.qa.demo.dao.Category;

import lombok.Data;


@Data
@Entity
@Table(name = "users")
public class User {

	//To link to primary
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	//Attributes
	private long id;
	@Column(length = 50, unique = true, nullable = false)
	private String email;
	@Column(length = 64, nullable = false)
	private String password;
	@Column(length = 25, nullable = false)
	private String firstName;
	@Column(length = 40, nullable = false)
	private String lastName;


	// blank constructor
	public User() {
		}
	
	// Constructor for ID
	public User(long id) {
		super();
		this.id = id;
	}
	
	// Constructor for User
	public User(String email, String password, String firstName, String lastName, Role role) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
//		this.role = role;
	}
	
	// Database bit follows - Pay ATTENTION !!!
	
//	@ManyToMany(cascade = CascadeType.PERSIST)
//	@JoinTable(
//			name = "user_role",
//			joinColumns = @JoinColumn(name = "user_id"),
//			inverseJoinColumns = @JoinColumn(name = "role_id")
//			)
//	// Foreign Key
//	private Role role;
}
