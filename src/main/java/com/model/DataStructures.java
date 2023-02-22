package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "data_structure")
public class DataStructures {
	
	@Column(name="id")
	private int id;
	
	@Column(name = "name")
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
