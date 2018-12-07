package com.hp.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface CRUDRepository<T, ID extends Serializable> extends Repository<T, ID>{
	void delete(T model);
	List<T> findAll();
	T findOne(ID id);
	T save(T model);
}
