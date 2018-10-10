package com.hp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hp.connectdatabase.DBConnection;
import com.hp.entity.CategoryEntity;
import com.hp.model.CategoryModel;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.apache.bcel.internal.generic.ReturnaddressType;
import com.sun.org.apache.regexp.internal.recompile;

public class CategoryDAO {
	public Connection getConnection() throws SQLException {
		return DBConnection.getDbCon().getConn();
	}

	public List<CategoryEntity> findAllCategory() throws Exception {
		String query = "SELECT * FROM book_store.bs_category";
		Statement stm = getConnection().createStatement();
		ResultSet rs = stm.executeQuery(query);
		List<CategoryEntity> categoryList = new ArrayList<CategoryEntity>();

		while (rs.next()) {
			CategoryEntity category = new CategoryEntity();
			category.setId(rs.getLong("id"));
			category.setName(rs.getString("name"));
			categoryList.add(category);
		}
		return categoryList;
	}

	public double caculateRevenueOfCategory(long id) throws Exception {
		double revenue = 0;
		String query = "SELECT  ifnull(sum(bb.price*bb.sold_number),0) as revenue FROM bs_book bb join bs_category bc on bc.id=bb.category_id WHERE bc.id="
				+ id + " GROUP BY bc.id";
		Statement stm = getConnection().createStatement();
		ResultSet rs = stm.executeQuery(query);
		if (rs.next()) {
			revenue = rs.getDouble("revenue");

		}
		return revenue;

	}

	public CategoryEntity findCategoryById(long id) throws Exception {
		String query = "SELECT * FROM book_store.bs_category where id = '" + id + "'";
		Statement stm = getConnection().createStatement();
		ResultSet rs = stm.executeQuery(query);
		if (rs.next()) {
			CategoryEntity category = new CategoryEntity();
			category.setId(rs.getLong("id"));
			category.setName(rs.getString("name"));
			return category;
		}
		return null;

	}

	public List<CategoryModel> calculateRevenueOfCategory() throws SQLException {
		long revenue = 0l;
		String query = "select bc.id as id, bc.name as name "
				+ ",ifnull(sum(bb.sold_number*bb.price),0) as revenue from bs_category bc"
				+ " left join bs_book bb on bb.category_id=bc.id " + " group by bc.id " + " order by revenue desc";
		Statement stmt = getConnection().createStatement();
		ResultSet resultSet = stmt.executeQuery(query);
		List<CategoryModel> categoryModels = new ArrayList<>();
		while (resultSet.next()) {
			CategoryModel model = new CategoryModel();
			model.setId(resultSet.getLong("id"));
			model.setName(resultSet.getString("name"));
			model.setRevenue(resultSet.getDouble("revenue"));
			categoryModels.add(model);
		}
		return categoryModels;
	}

	public boolean deleteCategoryById(int id) throws Exception {
		String query = " DELETE FROM bs_category WHERE id=" + id;
		Statement stm = getConnection().createStatement();
		int n = stm.executeUpdate(query);
		if (n != 0) {
			return true;
		}
		return false;
	}
	public boolean addCategory(CategoryEntity category) throws Exception{
		String query = "INSERT INTO bs_category (id, name) VALUE ("+category.getId()+", '"+category.getName()+"')";
		Statement stm = getConnection().createStatement();
		int n = stm.executeUpdate(query);
		if (n != 0) {
			return true;
		}
		return false;
	}
	public int generateId() throws Exception{
		String query = "select max(id) as id from bs_category";
		Statement stm =getConnection().createStatement();
		ResultSet rs = stm.executeQuery(query);
		if(rs.next()){
			return rs.getInt("id")+1;
		}
		return 0;
		
	}
	

}
