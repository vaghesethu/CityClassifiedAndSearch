package com.virtusa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.bean.Classified;

@Repository
public interface ClassifiedRepository extends JpaRepository<Classified, Integer> {
	List<Classified> findByUserId(int userId);
}
