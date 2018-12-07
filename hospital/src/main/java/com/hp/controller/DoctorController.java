package com.hp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hp.model.Doctor;
import com.hp.service.DoctorManagement;

@Controller
public class DoctorController {

	@Autowired
	DoctorManagement doctorManagement;

	@RequestMapping(value = "/addDoctor", method = RequestMethod.GET)
	public String addDoctor(Model model) {
		model.addAttribute("Doctor", new Doctor());
		return null;
	}

	@RequestMapping(value = "/addDoctor", method = RequestMethod.POST)
	public String addDoctor(@ModelAttribute("Doctor") Doctor doctor) {
		doctorManagement.save(doctor);
		return null;
	}

	@RequestMapping(value = "/deleteDoctor", method = RequestMethod.POST)
	public String deleteDoctor(@RequestParam("id") Integer id) {
		Doctor doctor = doctorManagement.findOne(id);
		doctor.setStatus(0);
		doctorManagement.save(doctor);
		return "redirect: listDoctor";
	}

	@RequestMapping(value = "/listDoctor", method = RequestMethod.GET)
	public String listDoctor(Model model) {
		model.addAttribute("listDoctor", doctorManagement.findAll());
		return null;
	}

}
