package com.hp.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hp.entity.RoleEntity;
import com.hp.model.RoleDTO;

@Component
public class RoleConverter {
	@Autowired
	private ModelMapper modelMapper;
	
	public RoleDTO entity2DTO (RoleEntity roleEntity){
		RoleDTO roleDTO = modelMapper.map(roleEntity, RoleDTO.class);
		return roleDTO;
	}
	
	public RoleEntity DTO2entity (RoleDTO roleDTO){
		RoleEntity roleEntity = modelMapper.map(roleDTO, RoleEntity.class);
		return roleEntity;
	}

}
