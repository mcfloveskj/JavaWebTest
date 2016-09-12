package com.spring.application.baseinfo.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.application.baseinfo.mapper.BaseInfoMapper;
import com.spring.application.baseinfo.model.BaseInfo;

@Service(value = "baseInfoService")
public class BaseInfoService {

	@Resource(name = "baseInfoMapper")
	private BaseInfoMapper baseInfoMapper;

	public List<BaseInfo> getPatientList(Map<String, Object> param) {
		return baseInfoMapper.getPatientList(param);
	}

	public BaseInfo queryByDbidkey(String dbidkey) {
		return baseInfoMapper.queryByDbidkey(dbidkey);
	}

	public void deleteByDbidkey(String dbidkey) {
		baseInfoMapper.deleteByDbidkey(dbidkey);
	}

	public void save(BaseInfo baseInfo) {
		baseInfoMapper.save(baseInfo);
	}

	public void update(BaseInfo baseInfo) {
		baseInfoMapper.update(baseInfo);
	}

}
