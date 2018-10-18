package com.hp.model;

import org.springframework.web.multipart.MultipartFile;

public class UserDTO {

	private String name;

	private int id;

	private String email;
	private MultipartFile avatar;

	public MultipartFile getAvatar() {
		return avatar;
	}

	public void setAvatar(MultipartFile avarta) {
		this.avatar = avarta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
