package com.qa.demo.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 25, nullable = false, unique =true)
	private String name;

	
	// Constructor for Name
	public Role(Long id) {
		super();
		this.id = id;
	}
	// Constructor for Name
	public Role(String name) {
		super();
		this.name = name;
	}
	public Role(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Role() {
	}
}