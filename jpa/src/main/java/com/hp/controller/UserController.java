package com.hp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hp.converter.UserConverter;
import com.hp.dao.RoleDAO;
import com.hp.dao.UserDAO;
import com.hp.entity.RoleUserEntity;
import com.hp.entity.UserEntity;
import com.hp.model.RoleDTO;
import com.hp.model.UserDTO;
import com.hp.service.RoleService;

@Controller
public class UserController {
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserDAO userDao;
	@Autowired
	private UserConverter userConverter;
	@Autowired
	private RoleDAO roleDao;

	@GetMapping("/add-user")
	public String user(Model model) {
		List<RoleDTO> roldeDtos = roleService.findAll();
		UserDTO dto = new UserDTO();
		dto.setRoleDto(roldeDtos);
		model.addAttribute("model", dto);
		return "user";
	}

	@PostMapping("/add-user")
	@Transactional
	public String user(Model model, @ModelAttribute("model") UserDTO userDTO) {
		UserEntity entity = userConverter.DTO2entity(userDTO);

		List<RoleUserEntity> roleUser = new ArrayList<RoleUserEntity>();

		for (String item : userDTO.getRoles()) {
			RoleUserEntity items = new RoleUserEntity();
			items.setRole(roleDao.findOneByName(item));
			items.setUser(entity);
			roleUser.add(items);
		}
		entity.setRoleUsers(roleUser);

		userDao.save(entity);

		return "user";
	}

	@GetMapping("/list-user")
	public String list(Model model) {
		List<UserEntity> user = userDao.findAll();

		model.addAttribute("model", user);
		return "listUser";
	}

	@GetMapping("/edit/{id}")
	@Transactional
	public String user(Model model, @PathVariable("id") Integer id) {
		UserEntity entity = userDao.findOneById(id);
		UserDTO userDTO = userConverter.entity2DTO(entity);
		List<RoleDTO> roldeDtos = roleService.findAll();
		userDTO.setRoleDto(roldeDtos);

		// check box
		String[] checkRole = new String[entity.getRoleUsers().size()];
		int i = 0;
		for (RoleUserEntity item : entity.getRoleUsers()) {
			checkRole[i] = item.getRole().getName();
			i++;
		}
		userDTO.setRoles(checkRole);
		model.addAttribute("model", userDTO);
		return "edituser";
	}
	
	@PostMapping("/edit-user")
	@Transactional
	public String editUser(Model model, @ModelAttribute("model") UserDTO userDTO) {
		UserEntity entity = userDao.findOneById(userDTO.getId());
		entity.setUsername(userDTO.getUsername());
		entity.setEmail(userDTO.getEmail());
		entity.setFullname(userDTO.getFullname());
		
		entity.getRoleUsers().clear();
        
		List<RoleUserEntity> roleUser = new ArrayList<RoleUserEntity>();
		for (String item : userDTO.getRoles()) {
			RoleUserEntity items = new RoleUserEntity();
			items.setRole(roleDao.findOneByName(item));
			items.setUser(entity);
			roleUser.add(items);
		}
		entity.getRoleUsers().addAll(roleUser);

		userDao.save(entity);

		return "redirect:/list-user";
	}

}
