package com.keysoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keysoft.converter.RoleConverter;
import com.keysoft.dao.RoleDAO;
import com.keysoft.entity.RoleEntity;
import com.keysoft.model.RoleDTO;
import com.keysoft.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleDAO roleDAO;
	@Autowired
	RoleConverter roleConverter;

	public void addRole(RoleDTO role) {
		roleDAO.addRole(roleConverter.dto2entity(role));

	}

	public void updateRole(RoleDTO role) {
		roleDAO.updateRole(roleConverter.dto2entity(role));

	}

	public void deleteRole(int id) {
		roleDAO.deleteRole(id);

	}

	public RoleDTO getRoleById(int id) {
		return roleConverter.entity2DTO(roleDAO.getRoleById(id));
	}

	public List<RoleDTO> getAllRole(){
		List<RoleDTO> listRoleDTO = new ArrayList<RoleDTO>();
		List<RoleEntity> listRoleEntity = roleDAO.getAllRole();
		for (RoleEntity roleEntity : listRoleEntity) {
			listRoleDTO.add(roleConverter.entity2DTO(roleEntity));
		}
		return listRoleDTO;
	}
	

}
