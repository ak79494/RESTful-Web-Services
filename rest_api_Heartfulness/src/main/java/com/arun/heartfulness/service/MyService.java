package com.arun.heartfulness.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arun.heartfulness.request.Employee;
@Service
public interface MyService {

	Employee add(Employee employee);
	
	Employee getDto(int pid);

	Employee update(int pid, Employee employee);

	Employee delete(int id);

	List<Employee> readAll();
	
}
