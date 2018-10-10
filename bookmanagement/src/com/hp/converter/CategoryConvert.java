package com.hp.converter;

import com.hp.dao.CategoryDAO;
import com.hp.entity.CategoryEntity;
import com.hp.model.CategoryModel;

public class CategoryConvert {
	CategoryDAO categoryDao = new CategoryDAO();
	
	
	public CategoryEntity dto2Entity(CategoryModel categoryModel){
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setId(categoryModel.getId());
		categoryEntity.setName(categoryModel.getName());
		return categoryEntity;
	}
	public CategoryModel entity2Dto(CategoryEntity categoryEntity){
		CategoryModel categoryModel = new CategoryModel();
		categoryModel.setId(categoryEntity.getId());
		categoryModel.setName(categoryEntity.getName());
		try {
			categoryModel.setRevenue(categoryDao.caculateRevenueOfCategory(categoryEntity.getId()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoryModel;
	}
	
	

}
