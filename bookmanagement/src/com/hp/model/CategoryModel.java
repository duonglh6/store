package com.hp.model;

public class CategoryModel {
	private long id;
	private String name;
	private Double revenue;
	
	
	public CategoryModel() {
		super();
	}
	public CategoryModel(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "CategoryModel [id=" + id + ", name=" + name + "]";
	}
	public Double getRevenue() {
		return revenue;
	}
	public void setRevenue(Double revenue) {
		this.revenue = revenue;
	}
	
}
