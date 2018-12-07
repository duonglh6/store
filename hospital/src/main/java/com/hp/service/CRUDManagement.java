package com.hp.service;

import java.io.Serializable;
import java.util.List;

public interface CRUDManagement <T, ID extends Serializable>{
	
	void delete(T model);

	List<T> findAll();

	T findOne(ID id);

	T save(T model);

}
