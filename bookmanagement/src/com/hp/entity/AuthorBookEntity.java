package com.hp.entity;

public class AuthorBookEntity {
private int id;
private int bookId;
private int authorId;
private float revenue;



public AuthorBookEntity(int id, int bookId, int authorId, float revenue) {
	super();
	this.id = id;
	this.bookId = bookId;
	this.authorId = authorId;
	this.revenue = revenue;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getBookId() {
	return bookId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}
public int getAuthorId() {
	return authorId;
}
public void setAuthorId(int authorId) {
	this.authorId = authorId;
}
public float getRevenue() {
	return revenue;
}
public void setRevenue(float revenue) {
	this.revenue = revenue;
}



}
