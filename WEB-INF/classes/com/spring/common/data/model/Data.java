package com.spring.common.data.model;

import java.util.List;

import com.spring.common.model.Entity;

public class Data extends Entity {

	private String code;

	List<DataColumn> dataColumn;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<DataColumn> getDataColumn() {
		return dataColumn;
	}

	public void setDataColumn(List<DataColumn> dataColumn) {
		this.dataColumn = dataColumn;
	}

}
