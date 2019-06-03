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
/***
 * 
 * @author Josip Bošnjak
 * 
 * <h2>Description</h2>
 * <p>This class receives user data from registration form,
 * as post request, then it sends response if there is any errors
 * to the view at the view that errors shows up near the field
 * with the error.</p>
 *
 */
@Controller
public class RegistrationController {
	private UserRepository userRepository;
	
	/***
	 * @author Josip Bošnjak
	 * @param userRepository repository which saves user data to the database
	 */
	@Autowired
	public RegistrationController(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	/***
	 * 
	 * @return Bycript encrypted password
	 */
	 @Bean
	  public BCryptPasswordEncoder passwordEncoder() {
	  return new BCryptPasswordEncoder();
	  }
	 
	 

	 /***
	  * @author Josip Bošnjak
	  * @param user - receive user data from form from registration view
	  * @param errors checks if there is any errors in form 
	  * @return login if there is no errors else return form with displayed errors
	  */
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
