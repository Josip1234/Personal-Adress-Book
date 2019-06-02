package com.josip.personal.address.book.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;

import com.josip.personal.address.book.data.access.layer.UserRepository;
import com.josip.personal.address.book.presentation.layer.User;

@Controller
public class RegistrationController {
	private UserRepository userRepository;
	
	@Autowired
	public RegistrationController(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	 @Bean
	  public BCryptPasswordEncoder passwordEncoder() {
	  return new BCryptPasswordEncoder();
	  }
	 
	 

	@PostMapping("/register/registerUser")
	public String register(@Valid User user, Errors errors ) {
		BCryptPasswordEncoder encoder = passwordEncoder();
		String password = encoder.encode(user.getPassword());
		user.setPassword(password);
		user.setRole("USER");
		if(errors.hasErrors()) {
			return "/registration";
		}
		userRepository.register(user);
		return "redirect:/login";
	}
	
}
