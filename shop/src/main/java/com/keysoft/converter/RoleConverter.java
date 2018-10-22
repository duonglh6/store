package com.keysoft.converter;

import org.springframework.stereotype.Component;

import com.keysoft.entity.RoleEntity;
import com.keysoft.model.RoleDTO;
@Component
public class RoleConverter {
	public RoleDTO entity2DTO(RoleEntity roleEntity) {
		RoleDTO roleDTO = new RoleDTO(roleEntity);
		return roleDTO;
	}
	public RoleEntity dto2entity(RoleDTO roleDTO) {
		RoleEntity roleEntity = new RoleEntity(roleDTO);
		return roleEntity;
	}

}
