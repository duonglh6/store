package com.keysoft.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.keysoft.entity.UserEntity;
import com.keysoft.model.UserDTO;
@Component
public class UserConverter {
	@Autowired
    private ModelMapper modelMapper;
	
	public UserDTO entity2DTO(UserEntity userEntity) {
		UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
		return userDTO;
	}
	public UserEntity dto2entity(UserDTO userDTO) {
		UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
		return userEntity;
	}
}
