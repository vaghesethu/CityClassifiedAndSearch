package com.cityclassifiedandsearch.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cityclassifiedandsearch.bean.User;

import java.util.*;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserEmail(String userEmail);
	User findByUserName(String userName);
	List<User> findAll();
	
}



