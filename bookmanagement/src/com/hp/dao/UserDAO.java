package com.hp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.hp.connectdatabase.DBConnection;
import com.hp.entity.UserEntity;

public class UserDAO {

	public Connection getConnection() {
		return DBConnection.getDbCon().getConn();
	}

	public UserEntity findUser(String email, String password) throws Exception {
		String query = "select * from bs_user where email = '" + email + "' AND password='" + password + "'";
		Statement stm = getConnection().createStatement();
		ResultSet rs = stm.executeQuery(query);
		if (rs.next()) {
			UserEntity user = new UserEntity();
			user.setDob(rs.getDate("dob"));
			user.setEmail(rs.getString("email"));
			user.setId(rs.getLong("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			return user;
		}
		return null;

	}
}
