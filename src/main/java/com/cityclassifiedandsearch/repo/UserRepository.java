package com.cityclassifiedandsearch.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cityclassifiedandsearch.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserEmail(String userEmail);
}
