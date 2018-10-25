package com.keysoft.service;

import java.util.List;
import java.util.Map;

import com.keysoft.model.RoleDTO;

public interface RoleService {
	public void addRole(RoleDTO role);
	public void updateRole(RoleDTO role);
	public void deleteRole(int id);
	public RoleDTO getRoleById(int id);
	public List<RoleDTO> getAllRole();
	Map<Integer, String> showAllRole();
}
