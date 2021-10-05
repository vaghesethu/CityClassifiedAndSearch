package com.virtusa.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.virtusa.bean.User;
import com.virtusa.service.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);
}
