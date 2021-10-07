package com.virtusa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.virtusa.bean.User;
import com.virtusa.service.UserService;

@Controller
public class UserController {
	private UserService userService;
	
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
		userService.save(user);
		return "redirect:/register?success";
	}
	
	@GetMapping("/otpverification")
	public String otpVerificationForm() {
		return "otpverification";
	}
	
	//post mapping for otpverification
}
