package com.keysoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keysoft.converter.UserConverter;
import com.keysoft.dao.RoleDAO;
import com.keysoft.dao.UserDAO;
import com.keysoft.entity.UserEntity;
import com.keysoft.model.UserDTO;
import com.keysoft.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserConverter converter;
	@Autowired
	private RoleDAO roleDAO;

	public void addUser(UserDTO user) {
		UserEntity entity = converter.dto2entity(user);

		entity.setRole(roleDAO.getRoleById(user.getRoleId()));

		userDAO.addUser(entity);

	}

	public void updateUser(UserDTO user) {
		// TODO Auto-generated method stub

	}

	public void deleteUser(int id) {
		// TODO Auto-generated method stub

	}

	public UserDTO getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserDTO> getAllUser() {
		List<UserDTO> userDTO = new ArrayList<UserDTO>();
		List<UserEntity> userEntity= userDAO.getAllUser();
		for (UserEntity user : userEntity) {
			userDTO.add(converter.entity2DTO(user));
			
		}
		
		return userDTO;
	}

}
