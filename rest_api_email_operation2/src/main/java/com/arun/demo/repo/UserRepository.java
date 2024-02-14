package com.arun.demo.repo;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.arun.demo.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("SELECT e FROM User e WHERE e.username = :username and e.password= :password")
	User findByUsername(String username,String password);
	@Query("SELECT e FROM User e WHERE e.username = :to")
	User findBy(String to);
	
}	