package com.spring.application.baseinfo.mapper;

import java.util.List;
import java.util.Map;

import com.spring.application.baseinfo.model.BaseInfo;
import com.spring.common.MybatisMapper;

@MybatisMapper
public interface BaseInfoMapper {

	public List<BaseInfo> getPatientList(Map<String, Object> param);

	public BaseInfo queryByDbidkey(String dbidkey);

	public void deleteByDbidkey(String dbidkey);

	public void save(BaseInfo baseInfo);

	public void update(BaseInfo baseInfo);

}
