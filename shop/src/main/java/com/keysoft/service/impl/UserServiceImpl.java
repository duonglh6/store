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

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserConverter converter;
	@Autowired
	private RoleDAO roleDAO;
	@Autowired
	RoleService roleService;

	public void addUser(UserDTO user) {
		UserEntity entity = converter.dto2entity(user);
		try {
			entity.setDob(sdf.parse(user.getDate()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		entity.setRole(roleDAO.getRoleById(user.getRoleId()));

		userDAO.addUser(entity);

	}

	public void updateUser(UserDTO user) {
		UserEntity entity = converter.dto2entity(user);
		try {
			entity.setDob(sdf.parse(user.getDate()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entity.setRole(roleDAO.getRoleById(user.getRoleId()));
		userDAO.updateUser(entity);

	}

	public void deleteUser(int id) {
		userDAO.deleteUser(id);

	}

	public UserDTO getUserById(int id) {
		UserEntity userEntity = userDAO.getUserById(id);
		UserDTO userDTO = converter.entity2DTO(userEntity);
		userDTO.setDate(sdf.format(userEntity.getDob()));
		userDTO.setRoleId(userEntity.getRole().getRoleId());
		userDTO.setListRole(roleService.showAllRole());

		return userDTO;
	}

	public List<UserDTO> getAllUser() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<UserDTO> listUserDTO = new ArrayList<UserDTO>();
		List<UserEntity> listUserEntity = userDAO.getAllUser();
		for (UserEntity userEntity : listUserEntity) {
			UserDTO userDTO = converter.entity2DTO(userEntity);
			userDTO.setDate(sdf.format(userEntity.getDob()));
			userDTO.setRoleId(userEntity.getRole().getRoleId());
//			userDTO.setListRole(roleService.showAllRole());
			listUserDTO.add(userDTO);
		}
		return listUserDTO;
	}

}
