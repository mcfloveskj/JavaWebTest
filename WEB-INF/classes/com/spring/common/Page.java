package com.spring.common;

import java.util.List;

public class Page<T> {

	private List<T> rows;

	private String page;

	private Integer total;

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer i) {
		this.total = i;
	}

}
