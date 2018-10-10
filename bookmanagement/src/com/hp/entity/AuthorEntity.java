package com.hp.entity;

import java.util.Date;

public class AuthorEntity {
private int id;
private String name;
private Date dob;

public AuthorEntity() {
	super();
}
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
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
@Override
public String toString() {
	return "AthorEntity [id=" + id + ", name=" + name + ", dob=" + dob + "]";
}
public AuthorEntity(int id, String name, Date dob) {
	super();
	this.id = id;
	this.name = name;
	this.dob = dob;
}

}
