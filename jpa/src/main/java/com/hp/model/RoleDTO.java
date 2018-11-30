package com.hp.model;

import org.springframework.stereotype.Component;

@Component
public class RoleDTO extends AbstractModel {
	private int id;

	private String description;

	private String name;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RoleDTO() {
		super();
	}


}
