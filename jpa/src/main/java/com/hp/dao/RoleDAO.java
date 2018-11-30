package com.hp.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hp.dao.customer.RoleRepositoryCustomized;
import com.hp.entity.RoleEntity;
@Repository
public interface RoleDAO extends BaseRepository<RoleEntity, Integer>{
	RoleEntity findById(int id);
	RoleEntity findOneByName(String name);
	@Query("SELECT r.name FROM RoleEntity r WHERE r.id = :id")
	String findNameById(@Param("id") int id);
	
	List<RoleEntity> findByDescription(String des);
	
	List<RoleEntity> findByDescriptionOrName(String des, String name);
	
	Long countByDescription(String des);
	
	List<RoleEntity> findDistinctByDescription(String des);
	
	List<RoleEntity> findTop2ByDescription(String des);
	
	
	Page<RoleEntity> findByDescriptionContainsOrNameContainsAllIgnoreCase(String des, String name,Pageable pageable);
	
	Integer countByDescriptionContainsOrNameContainsAllIgnoreCase(String des, String name);

}
