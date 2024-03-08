package com.arun.heartfulness.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arun.heartfulness.repo.JpaRepo;
import com.arun.heartfulness.request.Employee;

@Component
public class MyServiceImpl implements MyService {
	@Autowired
	private JpaRepo repo;
	@Override
	public Employee add(Employee dto) {
		
		return repo.save(dto);
		
		
	}
	public Employee getDto(int id) {
		return repo.findById(id).orElse(null);
	}
	@Override
	public Employee update(int pid, Employee dto) {
		Employee findById = repo.findById(pid).orElse(null);	
		
		if (findById != null) {
			findById.seteName(dto.geteName());
			findById.seteSalary(dto.geteSalary());
			Employee update = repo.save(findById);
			return update;
		} else {
			return null;
		}
		
	}
	@Override
	public Employee delete(int id) {
		Employee delete = repo.findById(id).orElse(null);

		if (delete != null) {
			repo.delete(delete);
			return delete;
		} else {
			return null;
		}
	}
	@Override
	public List<Employee> readAll() {
		
		return repo.findAll();
	}
	

}
