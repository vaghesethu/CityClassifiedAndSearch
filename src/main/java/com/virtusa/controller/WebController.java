package com.virtusa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.virtusa.bean.User;
import com.virtusa.repo.UserRepository;

@Controller
public class WebController {
	@Autowired
	UserRepository userrepo;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/register")
	public String showRegistrationForm() {
	   // model.addAttribute("user", new User());
	    return "register";
	}
	@PostMapping("/register")
	public User processRegister(User user) {
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	    userrepo.save(user);
		return user;
	    
	}
	@GetMapping("/users")
	public String listUsers(Model model) {
	    List<User> listUsers = userrepo.findAll();
	    model.addAttribute("listUsers", listUsers);
	     
	    return "users";
	}

}
