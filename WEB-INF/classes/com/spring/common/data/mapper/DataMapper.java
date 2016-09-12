package com.spring.common.data.mapper;

import java.util.List;
import java.util.Map;

import com.spring.common.MybatisMapper;
import com.spring.common.data.model.Data;
import com.spring.common.data.model.DataColumn;

@MybatisMapper
public interface DataMapper {

	Data queryByDbidkey(String dbidkey);

	List<Data> getDataList(Map<String, Object> param);

	public void deleteByDbidkey(String dbidkey);

	public void save(Data data);

	public void update(Data data);

	void deleteColumnByDbidkey(String dbidkey);

	void updateColumn(DataColumn dataColumn);

	void saveColumn(DataColumn dataColumn);

	List<DataColumn> getDataColumnList(Map<String, Object> param);

	DataColumn queryDataColumnByDbidkey(String dbidkey);

	void deleteColumnByDataDbidkey(String dbidkey);

}
