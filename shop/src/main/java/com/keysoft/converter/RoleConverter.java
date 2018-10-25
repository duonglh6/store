package com.keysoft.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.keysoft.entity.RoleEntity;
import com.keysoft.model.RoleDTO;
@Component
public class RoleConverter {
	@Autowired
    private ModelMapper modelMapper;
	public RoleDTO entity2DTO(RoleEntity roleEntity) {
		RoleDTO roleDTO = modelMapper.map(roleEntity, RoleDTO.class);
		return roleDTO;
	}
	public RoleEntity dto2entity(RoleDTO roleDTO) {
		RoleEntity roleEntity = modelMapper.map(roleDTO, RoleEntity.class);
		return roleEntity;
	}

}
