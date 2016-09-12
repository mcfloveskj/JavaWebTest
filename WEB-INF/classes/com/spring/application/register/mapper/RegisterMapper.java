package com.spring.application.register.mapper;

import java.util.List;
import java.util.Map;

import com.spring.application.register.model.Register;
import com.spring.common.MybatisMapper;

@MybatisMapper
public interface RegisterMapper {

	public List<Register> getRegisterList(Map<String, Object> param);

	public Register queryByDbidkey(String dbidkey);

	public void deleteByDbidkey(String dbidkey);

	public void save(Register register);

	public void update(Register register);

}
