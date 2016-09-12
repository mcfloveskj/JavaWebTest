package com.spring.application.register.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.application.register.mapper.RegisterMapper;
import com.spring.application.register.model.Register;

@Service(value = "registerService")
public class RegisterService {

	@Resource(name = "registerMapper")
	private RegisterMapper registerMapper;

	public List<Register> getRegisterList(Map<String, Object> param) {
		return registerMapper.getRegisterList(param);
	}

	public Register queryByDbidkey(String dbidkey) {
		return registerMapper.queryByDbidkey(dbidkey);
	}

	public void deleteByDbidkey(String dbidkey) {
		registerMapper.deleteByDbidkey(dbidkey);
	}

	public void save(Register register) {
		registerMapper.save(register);
	}

	public void update(Register register) {
		registerMapper.update(register);
	}
}
