package com.hp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hp.model.Session;
import com.hp.service.SessionManagement;

@Controller
public class SessionController {
	@Autowired
	SessionManagement sessionManagement;
	
	
	@RequestMapping(value = "/addSession", method = RequestMethod.GET)
	public String addSession(Model model){
		model.addAttribute("Session", new Session());
		return null;
	}
	
	@RequestMapping(value = "/addSession", method = RequestMethod.POST)
	public String addSession(@ModelAttribute("Session") Session session){
		sessionManagement.save(session);
		return null;
	}

}
