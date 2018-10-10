package com.hp.service;

import com.hp.converter.UserConverter;
import com.hp.dao.UserDAO;
import com.hp.entity.UserEntity;
import com.hp.model.UserModel;

public class UserService {

	private static UserDAO userDao = new UserDAO();
	private static UserConverter converterUser = new UserConverter();
	public UserModel checkLogin(String email,String password) throws Exception{
		if(!email.isEmpty() && !password.isEmpty()){
		UserEntity entity = userDao.findUser(email, password);
		UserModel model =converterUser.entity2Dto(entity);
		return 	model;
		}
		return null;
	}
}
