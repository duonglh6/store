package com.keysoft.model;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class UserDTO {

	
	private int userId;
	private String address;
	private String date;
	private String email;
	private String fullName;
	private byte gender;
	private String identityNumber;
	private String password;
	private String phoneNumber;
	private String username;
	private Integer roleId;
	private Map<Integer, String> listRole;
	
	
	
	
	
	public UserDTO() {
		super();
		
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public byte getGender() {
		return gender;
	}
	public void setGender(byte gender) {
		this.gender = gender;
	}
	public String getIdentityNumber() {
		return identityNumber;
	}
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Map<Integer, String> getListRole() {
		return listRole;
	}
	public void setListRole(Map<Integer, String> listRole) {
		this.listRole = listRole;
	}
	
}
