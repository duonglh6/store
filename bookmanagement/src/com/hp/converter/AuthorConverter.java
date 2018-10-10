package com.hp.converter;

import com.hp.entity.AuthorEntity;
import com.hp.model.AuthorModel;

public class AuthorConverter {
	public AuthorEntity dto2Entity(AuthorModel model) {
		AuthorEntity authorEntity = new AuthorEntity();
		authorEntity.setDob(model.getDob());
		authorEntity.setId(model.getId());
		authorEntity.setName(model.getName());
		return authorEntity;

	}
	public AuthorModel entity2Model(AuthorEntity entity) {
		AuthorModel authorModel = new AuthorModel();
		authorModel.setDob(entity.getDob());
		authorModel.setId(entity.getId());
		authorModel.setName(entity.getName());
		return authorModel;

	}


}
