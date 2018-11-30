package com.hp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hp.model.RoleDTO;
import com.hp.service.RoleService;

@Controller
public class RoleController {
	@Autowired
	RoleService roleService;
	
	
	@RequestMapping(value = "/add-role", method=RequestMethod.GET)
	public String addRole(ModelMap model, RoleDTO roleDTO){
		model.addAttribute("role", roleDTO);
		return "addRole";
	}
	
	@RequestMapping(value = "/add-role", method=RequestMethod.POST)
	public String addRole(@ModelAttribute("role") RoleDTO roleDTO){
		roleService.save(roleDTO);
		return null;
	}
	@RequestMapping(value = "/list-role", method=RequestMethod.GET)
	public String listRole(ModelMap model){
		roleService.findAll();
		return "listRole";
	}
	
	

}
