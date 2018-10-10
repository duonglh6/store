package com.hp.entity;

import java.util.Date;

public class UserEntity {
	private long id;
	private String email;
	private String password;
	private Date dob;
	private String name;
	
	
	
	
	
	public UserEntity() {
		super();
	}
	public UserEntity(long id, String email, String password, Date dob, String name) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + email + ", password=" + password + ", dob=" + dob + ", name=" + name
				+ "]";
	}
	
	
	

}
