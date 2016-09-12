package com.spring.common.login.model;

import java.util.List;

import com.spring.common.model.Entity;

public class Menu extends Entity {
	private String parentdbidkey;

	private String url;

	private Integer isleaf;

	private Integer tabindex;

	private List<Menu> children;

	public String getParentdbidkey() {
		return parentdbidkey;
	}

	public void setParentdbidkey(String parentdbidkey) {
		this.parentdbidkey = parentdbidkey;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getIsleaf() {
		return isleaf;
	}

	public void setIsleaf(Integer isleaf) {
		this.isleaf = isleaf;
	}

	public Integer getTabindex() {
		return tabindex;
	}

	public void setTabindex(Integer tabindex) {
		this.tabindex = tabindex;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}
}
