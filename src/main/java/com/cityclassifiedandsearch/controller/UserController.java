package com.cityclassifiedandsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cityclassifiedandsearch.bean.User;
import com.cityclassifiedandsearch.repo.UserRepository;
import com.cityclassifiedandsearch.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/login")
	public String userLoginForm() {
		return "login";
		
	}
	
	@GetMapping("/register")
	public String userRegistrationForm() {
		return "register";
	}
	
	@PostMapping("/register")
	public String userRegistration(@ModelAttribute("user") User user) {
		if(userRepository.findByUserEmail(user.getUserEmail())==null){
			userService.save(user);
			return "login";
		}else { 
			return "redirect:/register?registration-status=failed";
		}
	}
}
