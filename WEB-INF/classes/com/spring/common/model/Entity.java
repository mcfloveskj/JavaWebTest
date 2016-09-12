package com.spring.common.model;

public class Entity {
	private String dbidkey;

	private String name;

	private Integer status;

	private String id;

	public String getDbidkey() {
		return dbidkey;
	}

	public void setDbidkey(String dbidkey) {
		this.dbidkey = dbidkey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
