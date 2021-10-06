package com.virtusa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.virtusa.bean.User;
import com.virtusa.service.UserService;

@Controller
public class WebController {
	private UserService userService;
	
	public WebController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
    public User userRegistration() {
        return new User();
    }
	
	@GetMapping("/register")
	public String showUserRegisterationForm() {
		return "register";
	}
	
	@PostMapping("/register1")
	public String registerUserAccount(@ModelAttribute("user") User user) {
		System.out.println("Inside register1 controller");
		userService.save(user);
		return "redirect:/register?success";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/template")
	public String template() {
		return "template";
	}
}
