package com.hp.converter;

import com.hp.entity.UserEntity;
import com.hp.model.UserModel;

public class UserConverter {

	public UserEntity dto2Entity(UserModel user){
		UserEntity entity = new UserEntity();
		entity.setName(user.getName());
		entity.setPassword(user.getPassword());
		entity.setId(user.getId());
		entity.setDob(user.getDob());
		entity.setEmail(user.getEmail());
		return entity;
	}
	
	public UserModel entity2Dto(UserEntity user){
		UserModel model = new UserModel();
		model.setName(user.getName());
		model.setPassword(user.getPassword());
		model.setId(user.getId());
		model.setDob(user.getDob());
		model.setEmail(user.getEmail());
		return model;
	}
	
}
