package com.spring.common.login.mapper;

import java.util.List;

import com.spring.common.MybatisMapper;
import com.spring.common.login.model.User;

@MybatisMapper
public interface UserMapper {
	
	public List<User> getUserList();

	public List<User> getUserByUserName(String username);
	
}
