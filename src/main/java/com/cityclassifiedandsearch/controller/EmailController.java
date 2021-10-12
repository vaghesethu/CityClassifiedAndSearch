package com.cityclassifiedandsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cityclassifiedandsearch.bean.User;
import com.cityclassifiedandsearch.repo.UserRepository;
import java.util.*;

import javax.mail.MessagingException;

@Controller
public class EmailController {
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private SmtpMailSender smtpMailSender;
	
	public boolean EmailSubscription(String cityname, String address) {
		String subject = cityname + " added";
		String body = "Address: "+ address;
		List<User> test = userrepo.findAll();
		for(User u: test) {
			System.out.println("USER EMAIL HERE : "+ u.getUserEmail() + "\n");
			try {
				smtpMailSender.send(u.getUserEmail(), subject, body);
			} catch (MessagingException e) {
				System.out.println("MAIL NOT SENT");
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
}
