package com.hp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hp.connectdatabase.DBConnection;
import com.hp.entity.AuthorBookEntity;

public class AuthorBookDAO {
	public Connection getConnection() throws SQLException {
		return DBConnection.getDbCon().getConn();
	}

	public boolean addNewAuthorBook(AuthorBookEntity authorBook) throws Exception {
		String query = "INSERT INTO bs_author_book (id, author_id, book_id, revenue_share) VALUE (" + authorBook.getId()
				+ ", " + authorBook.getAuthorId() + ", " + authorBook.getBookId() + ", " + authorBook.getRevenue()
				+ ")";
		Statement stm = getConnection().createStatement();
		int n = stm.executeUpdate(query);
		if (n != 0) {
			return true;
		}

		return false;

	}

	public boolean deleteById(int id) throws Exception {

		String query = "DELETE FROM bs_author_book WHERE book_id = " + id;
		Statement stm = getConnection().createStatement();
		int n = stm.executeUpdate(query);
		if (n != 0) {
			return true;
		}

		return false;
	}
	
	public int generateId() throws Exception{
		String query = "SELECT MAX(id) AS id FROM bs_author_book";
		Statement stm = getConnection().createStatement();
		ResultSet rs= stm.executeQuery(query);
		if(rs.next()){
			return rs.getInt("id")+1;
		}
		return 0;
		
		
	}

}
