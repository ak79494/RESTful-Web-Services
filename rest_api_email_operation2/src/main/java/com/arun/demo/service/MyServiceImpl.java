package com.arun.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.arun.demo.entity.Email;
import com.arun.demo.entity.User;
import com.arun.demo.repo.EmailRepo;
import com.arun.demo.repo.UserRepository;
@Service
public class MyServiceImpl implements MyService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EmailRepo eRepo;
	@Override
	public User add(User user) {
		
		return userRepository.save(user);
		
	}
	public User add(String username, String password) {
		User findByUsername = userRepository.findByUsername(username,password);
		
		return findByUsername ;
	}
	public User send(String to) {
		User findeBy = userRepository.findBy(to);
		System.out.println("find By: "+findeBy);
		return findeBy;
	}
	public void save(Email sendRequest) {
		eRepo.save(sendRequest);
		
	}
	
	public List<Email> checkEmail(String to) {
		List<Email> findByTo = eRepo.findByTo(to);
		return findByTo;
	}
	public List<Email> checkSender(String from) {
		List<Email> findByFrom = eRepo.findByFrom(from);
		return findByFrom;
	}
}
