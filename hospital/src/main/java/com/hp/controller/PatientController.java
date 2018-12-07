package com.hp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PatientController {
	@RequestMapping(value = "/addPatient", method = RequestMethod.GET)
	public String addPatient(Model model){
		
		
		return null;
	}

}
