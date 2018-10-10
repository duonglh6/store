package com.hp.model;

public class BookModel {
	private int id;
	private String name;
	private long soldNumber;
	private double price;
	private CategoryModel category;
	
	
	
	
	public BookModel(int id, String name, long soldNumber, double price, CategoryModel category) {
		super();
		this.id = id;
		this.name = name;
		this.soldNumber = soldNumber;
		this.price = price;
		this.category = category;
	}
	public CategoryModel getCategory() {
		return category;
	}
	public void setCategory(CategoryModel category) {
		this.category = category;
	}
	public BookModel() {
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
	public long getSoldNumber() {
		return soldNumber;
	}
	public void setSoldNumber(long soldNumber) {
		this.soldNumber = soldNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BookModel [id=" + id + ", name=" + name + ", soldNumber=" + soldNumber + ", price=" + price + "]";
	}

}
