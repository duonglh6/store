package com.hp.dao.customer;

import java.util.List;

import com.hp.entity.RoleEntity;
import com.hp.model.RoleUserCustom;

public interface RoleRepositoryCustomized {
	List<RoleUserCustom> findBySearchTerm(String searchRole,String searchUser);

}
