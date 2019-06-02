package com.josip.personal.address.book.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.josip.personal.address.book.data.access.layer.UserRepository;

@Controller
public class RegistrationController {
	private UserRepository userRepository;
	
	@Autowired
	public RegistrationController(UserRepository userRepository) {
		this.userRepository=userRepository;
	}

	@PostMapping("/register/registerUser")
	public String register() {
		return "/login";
	}
	
}
