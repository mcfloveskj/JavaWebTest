package com.spring.common.login.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.common.login.mapper.MenuMapper;
import com.spring.common.login.model.Menu;

@Service(value = "menuService")
public class MenuService {

	@Resource(name = "menuMapper")
	private MenuMapper menuMapper;
	
	public List<Menu> getMenuList(){
		return menuMapper.getMenuList();
	}

	public List<Menu> getMenuListByParam(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return menuMapper.getMenuListByParam(param);
	}
	
}
