package com.arun.heartfulness.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arun.heartfulness.request.Employee;
@Repository
public interface JpaRepo extends JpaRepository<Employee, Integer> {
	
}
