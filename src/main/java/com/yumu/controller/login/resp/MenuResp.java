package com.yumu.controller.login.resp;

import java.util.ArrayList;
import java.util.List;

public class MenuResp {
	private String menuId;
	private String title;
	private String url;
	private String parentId;
	private List<MenuResp> child = new ArrayList<>();

	public String getMenuId() {
		return menuId;
	}

	public void setId(String menuId) {
		this.menuId = menuId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<MenuResp> getChild() {
		return child;
	}

	public void setChild(List<MenuResp> child) {
		this.child = child;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
}
