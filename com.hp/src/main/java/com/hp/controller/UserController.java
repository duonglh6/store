package com.hp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hp.model.UserDTO;
import com.hp.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	UserValidator userValidator;
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String sayHello(HttpServletRequest request) {
		UserDTO user = new UserDTO();
		user.setId(1);
		user.setName("Duonglh6");
		user.setEmail("Duonglh6@gmail.com");
		request.setAttribute("user", user);
		return ("hello");
	}

	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String sayHello(HttpServletRequest request, @ModelAttribute("user")  UserDTO user,
			BindingResult bindingResult) {
		MultipartFile file =user.getAvatar();
		try {
		File newfile = new File("E:/file-upload/" + file.getOriginalFilename());
		FileOutputStream fileOutputStream = new FileOutputStream(newfile);
		
		
			fileOutputStream.write(file.getBytes());
			fileOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		userValidator.validate(user, bindingResult);
//		if (bindingResult.hasErrors()) {
//			return ("hello");
//		}
		request.setAttribute("user", user);
		return "viewhello";
		
		
	}
	
	@RequestMapping(value = "/upload-file", method = RequestMethod.GET)
	public String upLoadFile(HttpServletRequest request) {
		return "upload";
	}
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upLoadFile(HttpServletRequest request, @RequestParam(name="file") MultipartFile file) {
		//MultipartFile map với request param (file) gửi lên từ client
		request.setAttribute("file", file);
		try {
		File newFile = new File("E:/file-upload/" + file.getOriginalFilename());
		FileOutputStream fileOutputStream = new FileOutputStream(newFile);
		
			fileOutputStream.write(file.getBytes());
		
		fileOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "viewfile";
	}

}
