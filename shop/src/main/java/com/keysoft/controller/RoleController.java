package com.keysoft.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.keysoft.model.RoleDTO;
import com.keysoft.service.RoleService;

@Controller
public class RoleController {
	@Autowired
	RoleService roleService;

	@RequestMapping(value = "/add-role", method = RequestMethod.GET)
	public String addUser(ModelMap model) {
		RoleDTO roleDTO = new RoleDTO();
		model.addAttribute("role", roleDTO);
		return "role/addRole";
	}

	@RequestMapping(value = "/add-role", method = RequestMethod.POST)
	public String addUser(HttpServletRequest request, @ModelAttribute("role") RoleDTO roleDTO) {
		roleService.addRole(roleDTO);
		return "redirect:/all-role";
	}

	@RequestMapping(value = "/all-role", method = RequestMethod.GET)
	public String showAllRole(ModelMap model) {

		model.addAttribute("listRole", roleService.getAllRole());
		return "role/showAllRole";

	}

	@RequestMapping(value = "/delete-role", method = RequestMethod.GET)
	public String deleteRole(ModelMap model, @RequestParam(value = "roleId") int roleId) {
		roleService.deleteRole(roleId);
		return "redirect:/all-role";

	}
	@RequestMapping(value = "/update-role", method = RequestMethod.GET)
	public String updateUser(ModelMap model, @RequestParam(value="roleId") int roleId) {
		model.addAttribute("role", roleService.getRoleById(roleId));
		return "role/updateRole";
	}

	@RequestMapping(value = "/update-role", method = RequestMethod.POST)
	public String updateUser(HttpServletRequest request, @ModelAttribute("role") RoleDTO roleDTO) {
		roleService.updateRole(roleDTO);;
		return "redirect:/all-role";
	}

}
