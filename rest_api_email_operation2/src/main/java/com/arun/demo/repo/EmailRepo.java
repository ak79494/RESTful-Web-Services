package com.arun.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.arun.demo.entity.Email;

public interface EmailRepo extends JpaRepository<Email, Integer>{
	
	  @Query("SELECT e FROM Email e Where e.to = :to")
	  
	  List<Email> findByTo(String to);
	  
	  @Query("SELECT e FROM Email e Where e.from = :from")
	  
	  List<Email> findByFrom(String from);
	 

}
