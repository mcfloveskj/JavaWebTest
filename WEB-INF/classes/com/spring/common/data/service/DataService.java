package com.spring.common.data.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.common.data.mapper.DataMapper;
import com.spring.common.data.model.Data;
import com.spring.common.data.model.DataColumn;

@Service(value = "dataService")
public class DataService {

	@Resource(name = "dataMapper")
	private DataMapper dataMapper;

	public Data queryByDbidkey(String dbidkey) {
		return dataMapper.queryByDbidkey(dbidkey);
	}

	public List<Data> getDataList(Map<String, Object> param) {
		return dataMapper.getDataList(param);
	}

	public void deleteByDbidkey(String dbidkey) {
		dataMapper.deleteByDbidkey(dbidkey);
	}

	public void save(Data data) {
		dataMapper.save(data);
	}

	public void update(Data data) {
		dataMapper.update(data);
	}

	public void deleteColumnByDbidkey(String dbidkey) {
		dataMapper.deleteColumnByDbidkey(dbidkey);
	}

	public void updateColumn(DataColumn dataColumn) {
		dataMapper.updateColumn(dataColumn);
	}

	public void saveColumn(DataColumn dataColumn) {
		dataMapper.saveColumn(dataColumn);
	}

	public List<DataColumn> getDataColumnList(Map<String, Object> param) {
		return dataMapper.getDataColumnList(param);
	}

	public DataColumn queryDataColumnByDbidkey(String dbidkey) {
		return dataMapper.queryDataColumnByDbidkey(dbidkey);
	}

	public void deleteColumnByDataDbidkey(String dbidkey) {
		dataMapper.deleteColumnByDataDbidkey(dbidkey);
	}
}
