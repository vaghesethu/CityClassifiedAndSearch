package com.cityclassifiedandsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cityclassifiedandsearch.bean.User;
import com.cityclassifiedandsearch.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	//private EmailController email;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	//Custom login page
	@GetMapping("/login")
	public String userLoginForm() {
		return "login";
	}
	
	//Registration Page
	@GetMapping("/register")
	public String userRegistrationForm() {
		//email.EmailSubscription("Chennai","kukjkjkj,palm");
		return "register";
	}
	@PostMapping("/register")
	public String userRegistration(Model model,@ModelAttribute("user") User user) {
		User user1=userService.save(user);
		if(user1==null)
		model.addAttribute("error","User Already Exists");	
		return "login";
	}
}
