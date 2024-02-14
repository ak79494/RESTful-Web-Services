package com.arun.demo.responce;

import java.util.List;

import org.springframework.stereotype.Component;

import com.arun.demo.entity.Email;

@Component
public class EmailResponce {
	public Boolean error;
	public String msg;
	private List<Email> email;
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
	public List<Email> getEmail() {
		return email;
	}
	public void setEmail(List<Email> email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "EmailResponce [error=" + error + ", msg=" + msg + ", email=" + email + "]";
	}
	
	
	
}
