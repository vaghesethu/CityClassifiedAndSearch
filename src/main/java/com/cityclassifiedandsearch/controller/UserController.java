package com.cityclassifiedandsearch.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cityclassifiedandsearch.bean.User;
import com.cityclassifiedandsearch.config.SmtpMailSender;
import com.cityclassifiedandsearch.service.UserService;

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
		System.out.println("USER SAVED /////// $$$$$$$$$");
		try {
			smtpMailSender.send("shivaram211999@gmail.com", "Test mail from Spring", "Shivaram");
			System.out.println("SUCCESS MAIL SENT //////////");
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			System.out.println(e+"EXCEPTION ////// LOOK HERE");
			e.printStackTrace();
			return "Failure";
		}
		return "redirect:/register?success";
		
	}
	
//	@Autowired
//    private JavaMailSender mailSender;	
//	public void sendEmail() {
//        // use mailSender here...
//		//JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//		String from = "cityclassifiedsearch@gmail.com";
//		String to = "cityclassifiedsearch@gmail.com";
//		 
//		SimpleMailMessage message = new SimpleMailMessage();
//		 
//		message.setFrom(from);
//		message.setTo(to);
//		message.setSubject("This is a plain text email");
//		message.setText("Hello guys! This is a plain text email.");
//		 
//		mailSender.send(message);
//    }  
	
	@Autowired
	private SmtpMailSender smtpMailSender;

	@RequestMapping("/send-mail")
	public String sendMail(){
		
		try {
			smtpMailSender.send("shivaram211999@gmail.com", "Test mail from Spring", "Howdy");
			return "SHIVARAM";
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			System.out.println(e+"EXCEPTION ////// LOOK HERE");
			e.printStackTrace();
		}
		return "SHIVARAM OUTSIDE";
		
	}

}
