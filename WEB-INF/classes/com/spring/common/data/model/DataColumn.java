package com.spring.common.data.model;

import com.spring.common.model.Entity;

public class DataColumn extends Entity {

	private String datadbidkey;

	private String code;

	public String getDatadbidkey() {
		return datadbidkey;
	}

	public void setDatadbidkey(String datadbidkey) {
		this.datadbidkey = datadbidkey;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
