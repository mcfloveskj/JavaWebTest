package com.spring.common.login.mapper;

import java.util.List;
import java.util.Map;

import com.spring.common.MybatisMapper;
import com.spring.common.login.model.Menu;

@MybatisMapper
public interface MenuMapper {
	
	public List<Menu> getMenuList();

	public List<Menu> getMenuListByParam(Map<String, Object> param);
	
}
