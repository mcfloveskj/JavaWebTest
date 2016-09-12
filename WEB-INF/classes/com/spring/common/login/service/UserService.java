package com.spring.common.login.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.common.login.mapper.UserMapper;
import com.spring.common.login.model.User;

@Service(value = "userService")
public class UserService {

	@Resource(name = "userMapper")
	private UserMapper userMapper;
	
	public List<User> getUserList(){
		return userMapper.getUserList();
	}

	public List<User> getUserByUserName(String username) {
		return userMapper.getUserByUserName(username);
	}
	
}
