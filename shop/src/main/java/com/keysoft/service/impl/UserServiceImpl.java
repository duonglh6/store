package com.keysoft.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keysoft.converter.UserConverter;
import com.keysoft.dao.RoleDAO;
import com.keysoft.dao.UserDAO;
import com.keysoft.entity.UserEntity;
import com.keysoft.model.UserDTO;
import com.keysoft.service.RoleService;
import com.keysoft.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserConverter converter;
	@Autowired
	private RoleDAO roleDAO;
	@Autowired
	private RoleService roleService;

	public void addUser(UserDTO user) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		UserEntity entity = converter.dto2entity(user);
		try {
			entity.setDob(dateFormat.parse(user.getDate()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
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
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		UserEntity entity = userDAO.getUserById(id);
		UserDTO dto = converter.entity2DTO(entity);
		dto.setDate(dateFormat.format(entity.getDob()));
		dto.setRoleId(entity.getRole().getRoleId());
		dto.setListRole(roleService.showAllRole());
		return  dto;
	}

	public List<UserDTO> getAllUser() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		List<UserDTO> userDTO = new ArrayList<UserDTO>();
		List<UserEntity> userEntity= userDAO.getAllUser();
		for (UserEntity user : userEntity) {
			UserDTO dto = converter.entity2DTO(user);
			dto.setDate(dateFormat.format(user.getDob()));
			userDTO.add(dto);
			
			
		}
		
		return userDTO;
	}

}
