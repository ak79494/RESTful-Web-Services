package com.arun.demo.responce;

import java.util.List;

import org.springframework.stereotype.Component;

import com.arun.demo.entity.User;
@Component
public class ProductResponce {
	public Boolean error;
	public String msg;
	private List<User> user;
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
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	
}
