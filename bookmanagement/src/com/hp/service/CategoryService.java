package com.hp.service;

import java.util.ArrayList;
import java.util.List;

import com.hp.converter.CategoryConvert;
import com.hp.dao.CategoryDAO;
import com.hp.entity.CategoryEntity;
import com.hp.model.CategoryModel;

public class CategoryService {
	private CategoryDAO categoryDao = new CategoryDAO();
	private CategoryConvert categoryConverter = new CategoryConvert();

	public List<CategoryModel> getRevenueOfCategory() throws Exception {
		List<CategoryEntity> entity = categoryDao.findAllCategory();
		List<CategoryModel> model = new ArrayList<>();
		for (CategoryEntity entity1 : entity) {
			model.add(categoryConverter.entity2Dto(entity1));
		}
		return model;

	}
	public void deleteCategoryById(int id) throws Exception{
		categoryDao.deleteCategoryById(id);
	}
	public void addCategory(CategoryEntity category) throws Exception{
		categoryDao.addCategory(category);
	}
	public int generateId() throws Exception{
		return categoryDao.generateId();
	}
	public CategoryEntity findCategoryById(int id) throws Exception{
		return categoryDao.findCategoryById(id);
	}

}
