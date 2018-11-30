package com.hp.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hp.entity.RoleEntity;
import com.hp.entity.UserEntity;
import com.hp.model.RoleDTO;
import com.hp.model.UserDTO;
@Component
public class UserConverter {
	@Autowired
	private ModelMapper modelMapper;
	
	public UserDTO entity2DTO (UserEntity userEntity){
		UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
		return userDTO;
	}
	
	public UserEntity DTO2entity (UserDTO userDTO){
		UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
		return userEntity;
	}
}
