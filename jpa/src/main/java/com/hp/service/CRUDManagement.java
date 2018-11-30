package com.hp.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface CRUDManagement<T, PK extends Serializable> extends GenericManagement<T, PK> {
	
	void delete(T t);

	List<T> findAll();

	Optional<T> findOne(PK id);

	T save(T persisted);
}
