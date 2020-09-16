package com.yumu.controller;

public class RequestPage<T> {

	private int pageSize;
	private int pageNum;
	private String[] ascs;
	private String[] descs;
	private T condition;

	public RequestPage() {
	}

	public RequestPage(int pageSize, int pageNum, String[] ascs, String[] descs, T condition) {
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.ascs = ascs;
		this.descs = descs;
		this.condition = condition;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public String[] getAscs() {
		return ascs;
	}

	public void setAscs(String[] ascs) {
		this.ascs = ascs;
	}

	public String[] getDescs() {
		return descs;
	}

	public void setDescs(String[] descs) {
		this.descs = descs;
	}

	public T getCondition() {
		return condition;
	}

	public void setCondition(T condition) {
		this.condition = condition;
	}
}
