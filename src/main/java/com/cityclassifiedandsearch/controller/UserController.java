package com.cityclassifiedandsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cityclassifiedandsearch.bean.User;
import com.cityclassifiedandsearch.repo.UserRepository;
import com.cityclassifiedandsearch.service.UserService;
import com.cityclassifiedandsearch.controller.EmailController;
import java.util.*;

import javax.mail.MessagingException;

@Controller
public class UserController {
	private UserService userService;
	private EmailController email;
	@Autowired
	private UserRepository userrepo;

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
		
		//email.EmailSubscription("Chennai","kukjkjkj,palm");
		
		return "register";
	}
	
	@PostMapping("/register")
	public String userRegistration(@ModelAttribute("user") User user) {
		userService.save(user);
		return "login";
	}
	
	
}
