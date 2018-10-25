package com.keysoft.controller;

import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		return "user/addUser";
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public String addUser(ModelMap map, @ModelAttribute("user") UserDTO userDTO
			) {
		//tat ca dua vao service xu ly controller chi goi ra ! :D
		userService.addUser(userDTO);
		return "redirect:/all-user";
	}

	@RequestMapping(value = "/all-user", method = RequestMethod.GET)
	public String allUser(Model model) {
		// UserDTO user = new UserDTO();
		// Map<Integer, String> listRole = roleService.showAllRole();
		// user.setListRole(listRole);
		model.addAttribute("listUser", userService.getAllUser());
		return "user/showAllUser";
	}

	@RequestMapping(value = "/date-time", method = RequestMethod.GET)
	public String dateTime(Model model) {
		// UserDTO user = new UserDTO();
		// user.setListRole(roleService.showAllRole());
		// model.addAttribute("user", user);
		return "user/testDateTime";
	}

	@RequestMapping(value = "/date-time", method = RequestMethod.POST)
	public String dateTime(Model model, @RequestParam("dateTime") String dateTime) {
		model.addAttribute("dateTime", dateTime);
		return "user/viewDateTime";
	}
	
	@RequestMapping(value = "/edit-user/{idUser}", method = RequestMethod.GET)
	public String editUser(Model model,@PathVariable("idUser") Integer id) {
		UserDTO dto = userService.getUserById(id);
	   model.addAttribute("user", dto);
		return "user/edit";
	}
}
