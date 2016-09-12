package com.spring.common.login.model;

import com.spring.common.model.Entity;

public class User extends Entity{

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
