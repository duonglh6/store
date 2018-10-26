package com.keysoft.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.keysoft.model.UserDTO;
import com.keysoft.service.RoleService;
import com.keysoft.service.UserService;

@Controller
public class UserController {
	@Autowired
	RoleService roleService;
	@Autowired
	UserService userService;

	@RequestMapping(value = "/add-user", method = RequestMethod.GET)
	public String addUser(Model model) {
		UserDTO user = new UserDTO();
		Map<Integer, String> listRole = roleService.showAllRole();
		user.setListRole(listRole);
		model.addAttribute("user", user);
		return "addUser";
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public String addUser(ModelMap map, @ModelAttribute("user") UserDTO userDTO) {
		userService.addUser(userDTO);
		return "redirect:/all-user";
	}

	@RequestMapping(value = "/all-user", method = RequestMethod.GET)
	public String allUser(Model model) {
		model.addAttribute("listUser", userService.getAllUser());
		return "showAllUser";
	}

	@RequestMapping(value = "/delete-user/{id}", method = RequestMethod.GET)
	public String deleteUser(Model model, @PathVariable("id") Integer id) {
		userService.deleteUser(id);
		return "redirect:/all-user";
	}

	@RequestMapping(value = "/update-user/{id}", method = RequestMethod.GET)
	public String updateUser(Model model, @PathVariable("id") int id) {
		model.addAttribute("user", userService.getUserById(id));
		return "updateUser";
	}

	@RequestMapping(value = "/update-user/{id}", method = RequestMethod.POST)
	public String updateUser(Model model, @ModelAttribute("user") UserDTO user) {
		userService.updateUser(user);
		return "redirect:/all-user";
	}

}
