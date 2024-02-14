package com.arun.demo.controller;

import java.util.Arrays;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arun.demo.entity.Email;
import com.arun.demo.entity.User;
import com.arun.demo.repo.UserRepository;
import com.arun.demo.responce.EmailResponce;
import com.arun.demo.responce.ProductResponce;
import com.arun.demo.service.MyServiceImpl;

@RestController
public class MyController {
	 @Autowired
	    private UserRepository userRepository;
	 @Autowired
	 private MyServiceImpl service;
	 @Autowired 
	 private ProductResponce responce;
	 @Autowired
	 private EmailResponce eresponce;
	    @PostMapping("/register")
	    public ResponseEntity<ProductResponce> registerUser(@RequestBody User user) {
	    	
	    	 User add = service.add(user);
	    	 if(add!=null) {
	    		 responce.setError(false);
	 			
	 			
	 			responce.setMsg("Registar successfully");
	 			responce.setUser(Arrays.asList(add));
	 			return new ResponseEntity<>(responce,HttpStatus.OK);
	 			
	 		}else {
	 			responce.setError(true);
	 			responce.setMsg("Registration failed");
	 			responce.setUser(null);
	 			return new ResponseEntity<>(responce,HttpStatus.NOT_FOUND);
	    	 }

	       
	    }
	    @PostMapping("/login")
	    public ResponseEntity<ProductResponce> loginUser( @RequestBody User user) {
	    	User user1 = service.add(user.getUsername(), user.getPassword());
	    	if(user1!=null) {
	    		 responce.setError(false);
	 			responce.setMsg("login successfully");
	 			responce.setUser(Arrays.asList(user1));
	 			return new ResponseEntity<>(responce,HttpStatus.OK);
	 			
	 		}else{
	 			responce.setError(true);
	 			responce.setMsg("login failed");
	 			responce.setUser(null);
	 			return new ResponseEntity<>(responce,HttpStatus.NOT_FOUND);
	    	 }
	    	  
	    }
	 

	    @PostMapping("/sendEmail")
	    public  ResponseEntity<ProductResponce> send(@RequestBody Email sendRequest) {
	        System.out.println(sendRequest);
	        User send = service.send(sendRequest.getTo());
	        System.out.println(send);
	        if(send!=null) {
	        	service.save(sendRequest);
	        }
	        
	        if(send!=null) {
	    		 responce.setError(false);
	 			responce.setMsg("Email Send successfully");
	 			
	 			return new ResponseEntity<>(responce,HttpStatus.OK);
	 			
	 		}else{
	 			responce.setError(true);
	 			responce.setMsg("send failed");
	 			
	 			return new ResponseEntity<>(responce,HttpStatus.NOT_FOUND);
	    	 }
	    	  
	        
	    }
	    @GetMapping("/inbox")
	    public  ResponseEntity<EmailResponce> inbox(@RequestBody Email email) {
	    	java.util.List<Email> list = service.checkEmail(email.getTo());
	    	System.out.println(list);
	    	if(list!=null) {
	    		 eresponce.setError(false);
	    		 
	 			eresponce.setMsg("Indbox Message");
	 			eresponce.setEmail(list);
	 			
	 			return new ResponseEntity<>(eresponce,HttpStatus.OK);
	 			
	 		}else{
	 			eresponce.setError(true);
	 			eresponce.setMsg("send failed");
	 			
	 			return new ResponseEntity<>(eresponce,HttpStatus.NOT_FOUND);
	    	 }
	    	  
	        
	    }
	    @GetMapping("/sent")
	    public  ResponseEntity<EmailResponce> sent(@RequestBody Email email) {
	    	java.util.List<Email> sender = service.checkSender(email.getFrom());
	    	System.out.println(sender);
	    	if(sender!=null) {
	    		 eresponce.setError(false);
	 			eresponce.setMsg("you send message");
	 			eresponce.setEmail(sender);
	 			
	 			return new ResponseEntity<>(eresponce,HttpStatus.OK);
	 			
	 		}else{
	 			eresponce.setError(true);
	 			eresponce.setMsg("No Emailed");
	 			
	 			return new ResponseEntity<>(eresponce,HttpStatus.NOT_FOUND);
	    	 }
	    	  
	        
	    }
	     	
}
