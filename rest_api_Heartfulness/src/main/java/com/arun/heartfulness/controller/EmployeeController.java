package com.arun.heartfulness.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arun.heartfulness.request.Employee;
import com.arun.heartfulness.responce.ProductsResponce;
import com.arun.heartfulness.service.MyService;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	private MyService service;
	@Autowired
	private ProductsResponce response;

	/* save Employee */
	@PostMapping("/")
	public ResponseEntity<ProductsResponce> product(@RequestBody Employee employee) {
		
			Employee savedEmployee=service.add(employee);
			if(savedEmployee!=null) {
			System.out.println(employee);
			response.setError(false);
			
			
			response.setMsg("request data received and providing success responce");
			response.setProducts(Arrays.asList(employee));
			return new ResponseEntity<>(response,HttpStatus.OK);
			
		}else {
			response.setError(true);
			response.setMsg("failed to product");
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			
		}
	}

	/* get all the employees */
	@GetMapping("/list")
	public ResponseEntity<ProductsResponce> getEmployees() {
		
		List<Employee> allEmployee=service.readAll();
		if(allEmployee!=null) {
	
		response.setError(false);
		
		
		response.setMsg("request data received and providing success responce");
		response.setProducts(allEmployee);
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}else {
		response.setError(true);
		response.setMsg("failed to product");
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	
	 
		
	}
		
		
	
	}

	/* get specific employee by id */
	@GetMapping("/{eid}")
	public ResponseEntity<ProductsResponce> getEmployeeById(@PathVariable("eid") int eid) {
		Employee employee = service.getDto(eid);
		
		if(employee!=null) {
			response.setError(false);
			response.setMsg("request data received and providing success responce");
			response.setProducts(Arrays.asList(employee));
			return new ResponseEntity<>(response,HttpStatus.OK);
			
		}else {
			response.setError(true);
			response.setMsg("failed to product");
			response.setProducts(null);
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
	}

	/* update employee */
	@PutMapping("/{eid}")
	public ResponseEntity<ProductsResponce> updateEmployee(@PathVariable("eid") int eid,@RequestBody Employee productdto) {
		Employee updateEmployee = service.update(eid,productdto);
		if(updateEmployee!=null) {
			response.setError(false);
			response.setMsg("request data received and providing success responce");
			response.setProducts(Arrays.asList(updateEmployee));
			return new ResponseEntity<>(response,HttpStatus.OK);
			
		}else {
			response.setError(true);
			response.setMsg("failed to product");
			response.setProducts(null);
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
	}

	/* delete employee by id */
	@DeleteMapping("/{eid}")
	public ResponseEntity<ProductsResponce> deleteEmployee(@PathVariable int eid) {
		Employee deleteEmployee = service.delete(eid);

		if (deleteEmployee != null) {
			response.setError(false);
			response.setMsg("Data Delete Successfully");
			response.setProducts(Arrays.asList(deleteEmployee));

			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMsg("Failed to Delete");
			response.setProducts(null);

			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	
	}
}
