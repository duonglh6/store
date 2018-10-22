package com.keysoft.dao;

import java.util.List;

import com.keysoft.entity.RoleEntity;

public interface RoleDAO {
	public void addRole(RoleEntity role);
	public void updateRole(RoleEntity role);
	public void deleteRole(int id);
	public RoleEntity getRoleById(int id);
	public List<RoleEntity> getAllRole( );

}
