package com.arun.heartfulness.responce;

import java.util.List;

import org.springframework.stereotype.Component;

import com.arun.heartfulness.request.Employee;

@Component
public class ProductsResponce {

	public Boolean error;
	public String msg;
	private List<Employee> products;
	public Boolean getError() {
		return error;
	}
	public void setError(Boolean error) {
		this.error = error;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<Employee> getProducts() {
		return products;
	}
	public void setProducts(List<Employee> products) {
		this.products = products;
	}
	
}
