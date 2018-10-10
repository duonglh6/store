package com.hp.model;

import java.util.Date;

public class AuthorModel {
	private int id;
	private String name;
	private Date dob;
	private double revenue;
	
	
	
	public AuthorModel() {
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
	public double getRevenue() {
		return revenue;
	}
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	public AuthorModel(int id, String name, Date dob, double revenue) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.revenue = revenue;
	}
	
	

}
