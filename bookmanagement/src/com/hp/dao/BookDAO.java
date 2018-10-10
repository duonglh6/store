package com.hp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hp.connectdatabase.DBConnection;
import com.hp.entity.BookEntity;

public class BookDAO {
	public Connection getConnection() throws SQLException {
		return DBConnection.getDbCon().getConn();
	}

	public boolean updateBook(BookEntity book) throws Exception {
		String query = "UPDATE bs_book SET name='" + book.getName() + "', category_id=" + book.getCategory().getId()
				+ ", sold_number=" + book.getSoldNumber() + ", price=" + book.getPrice() + " WHERE id=" + book.getId();
		Statement stm = getConnection().createStatement();
		int n = stm.executeUpdate(query);
		if (n != 0) {
			return true;
		}
		return false;
	}

	public boolean addBook(BookEntity book) throws Exception {
		// String query = "INSERT INTO bs_book (id, 'name', category_id,
		// sold_number, price) VALUES (" + book.getId() + ", '"
		// + book.getName() + "', " + book.getCategory().getId() + ", " +
		// book.getSoldNumber() + ", " + book.getPrice()
		// + ")";
		// Statement stm = getConnection().createStatement();
		// int n = stm.executeUpdate(query);
		// if (n != 0) {
		// return true;
		// }
		//
		// return false;
		String query = "insert into bs_book(id,name,price,category_id,sold_number) values (" + book.getId() + ",'"
				+ book.getName() + "'," + book.getPrice() + "," + book.getCategory().getId() + ","
				+ book.getSoldNumber() + ")";
		Statement stmt = getConnection().createStatement();
		int n = stmt.executeUpdate(query);
		if (n != 0)
			return true;
		return false;

	}

	public boolean deleteBook(int id) throws Exception {
		String query = " DELETE FROM bs_book WHERE id=" + id;
		Statement stm = getConnection().createStatement();
		int n = stm.executeUpdate(query);
		if (n != 0) {
			return true;
		}
		return false;
	}

	public List<BookEntity> findBook() throws Exception {
		CategoryDAO categoryDAO = new CategoryDAO();
		String query = " select * from bs_book";
		Statement stm = getConnection().createStatement();
		ResultSet rs = stm.executeQuery(query);
		List<BookEntity> bookList = new ArrayList<>();
		while (rs.next()) {
			BookEntity book = new BookEntity();
			book.setId(rs.getInt("id"));
			book.setCategory(categoryDAO.findCategoryById(rs.getLong("category_id")));
			book.setName(rs.getString("name"));
			book.setPrice(rs.getDouble("price"));
			book.setSoldNumber(rs.getLong("sold_number"));
			bookList.add(book);
		}

		return bookList;
	}

	public BookEntity findBookById(long id) throws Exception {
		CategoryDAO categoryDAO = new CategoryDAO();
		String query = "SELECT * FROM bs_book where id = " + id + "";
		Statement stm = getConnection().createStatement();
		ResultSet rs = stm.executeQuery(query);
		BookEntity book = new BookEntity();
		if (rs.next()) {
			book.setId(rs.getInt("id"));
			book.setCategory(categoryDAO.findCategoryById(rs.getLong("category_id")));
			book.setName(rs.getString("name"));
			book.setPrice(rs.getDouble("price"));
			book.setSoldNumber(rs.getLong("sold_number"));
		}
		return book;
	}

	public boolean addNewBook(BookEntity bookEntity) throws Exception {
		String query = "INSERT INTO bs_book (id, name, category_id, sold_number, price) VALUE" + " ("
				+ bookEntity.getId() + ", '" + bookEntity.getName() + "', " + bookEntity.getCategory().getId() + ", "
				+ bookEntity.getSoldNumber() + ", " + bookEntity.getPrice() + ")";
		Statement stm = getConnection().createStatement();
		int n = stm.executeUpdate(query);
		if (n != 0) {
			return true;
		} else {
			return false;
		}

	}

	public int generateId() throws Exception {
		String query = "SELECT MAX(id) AS id FROM bs_book";
		Statement stm = getConnection().createStatement();
		ResultSet rs = stm.executeQuery(query);
		if(rs.next()){
			return rs.getInt("id") + 1;	
		}
		return 0;	

	}

}
