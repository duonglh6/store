package com.hp.service;

import java.util.ArrayList;
import java.util.List;

import com.hp.converter.AuthorConverter;
import com.hp.dao.AuthorDAO;
import com.hp.entity.AuthorEntity;
import com.hp.model.AuthorModel;

public class AuthorService {
	private AuthorDAO authorDAO = new AuthorDAO();
	private AuthorConverter authorConverter = new AuthorConverter();

	public List<AuthorModel> getRevenueByAuthor() throws Exception {

		List<AuthorEntity> authorEntityList = authorDAO.getAllAuthor();

		List<AuthorModel> authorModelList = new ArrayList<>();

		for (AuthorEntity item : authorEntityList) {

			AuthorModel model = authorConverter.entity2Model(item);

			model.setRevenue(authorDAO.getRevenueByid(item.getId()));
			
			authorModelList.add(model);
		}
		return authorModelList;

	}
	
	public void addNewAuthor(AuthorEntity author) throws Exception{
		authorDAO.addNewAuthor(author);
	}
	public int generateId() throws Exception{
		return authorDAO.generateId();
	}
	public void deleteAuthor(int id) throws Exception{
		 authorDAO.deleteAuthor(id);
	}

}
