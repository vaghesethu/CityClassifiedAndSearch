package com.virtusa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.bean.Classified;

public interface ClassifiedRepository extends JpaRepository<Classified, Integer> {

}
