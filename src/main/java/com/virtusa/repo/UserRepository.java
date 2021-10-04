package com.virtusa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.bean.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserEmail(String userEmail);
	User findByUserName(String userName);
}
