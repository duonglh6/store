package com.hp.entity;

public class BookEntity {
private int id;
private String name;
private CategoryEntity category;
private long soldNumber;
private double price;





public BookEntity() {
	super();
}

public BookEntity(int id, String name, CategoryEntity category, long soldNumber, double price) {
	super();
	this.id = id;
	this.name = name;
	this.category = category;
	this.soldNumber = soldNumber;
	this.price = price;
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
public CategoryEntity getCategory() {
	return category;
}
public void setCategory(CategoryEntity category) {
	this.category = category;
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
	return "BookEntity [id=" + id + ", name=" + name + ", category=" + category + ", soldNumber=" + soldNumber
			+ ", price=" + price + "]";
}




}
