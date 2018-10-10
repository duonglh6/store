package com.hp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.hp.connectdatabase.DBConnection;
import com.hp.entity.AuthorEntity;

public class AuthorDAO {
	public Connection getConnection() {
		return DBConnection.getDbCon().getConn();
	}

	public List<AuthorEntity> getAllAuthor() throws Exception {

		String query = "SELECT * FROM bs_author";
		Statement stm = getConnection().createStatement();
		ResultSet rs = stm.executeQuery(query);
		List<AuthorEntity> authorList = new ArrayList<>();
		while (rs.next()) {
			AuthorEntity author = new AuthorEntity();
			author.setDob(rs.getDate("dob"));
			author.setId(rs.getInt("id"));
			author.setName(rs.getString("name"));
			authorList.add(author);
		}

		return authorList;

	}

	public double getRevenueByid(long id) throws Exception {
		double revenue = 0.0f;
		String query = "select ifnull(sum(bb.price*bb.sold_number),0) as revenue "
				+ "from bs_book bb join bs_author_book bab " + "on bb.id=bab.book_id join bs_author ba "
				+ "on ba.id=bab.author_id where ba.id=" + id + " group by ba.id";
		Statement stm = getConnection().createStatement();
		ResultSet rs = stm.executeQuery(query);
		if (rs.next()) {
			revenue = rs.getDouble("revenue");
		}
		return revenue;

	}
	
	public boolean addNewAuthor(AuthorEntity author) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String query = "INSERT INTO bs_author (id, name, dob) VALUE ("+author.getId()+", '"+author.getName()+"', '"+ sdf.format(author.getDob())+"')";
		Statement stm = getConnection().createStatement();
		int n = stm.executeUpdate(query);
		if(n!=0){
			return true;
		}
		return false;
	}
	public int generateId() throws Exception{
		String query = " SELECT MAX(id) AS id FROM bs_author";
		Statement stm = getConnection().createStatement();
		ResultSet rs = stm.executeQuery(query);
		if(rs.next()){
			return rs.getInt("id")+1;
		}
		return 0;
	}
	public boolean deleteAuthor(int id) throws Exception{
		String query = "DELETE FROM bs_author WHERE id="+id;
		Statement stm = getConnection().createStatement();
		int n = stm.executeUpdate(query);
		if(n!=0){
			return true;
		}
		return false;
	}
}
