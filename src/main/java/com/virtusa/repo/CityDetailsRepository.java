package com.virtusa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.bean.CityDetails;

@Repository
public interface CityDetailsRepository extends JpaRepository<CityDetails, Integer> {
	List<CityDetails> findByUserId(int userId);
}
