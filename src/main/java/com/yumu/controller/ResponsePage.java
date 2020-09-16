package com.yumu.controller;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.yumu.tool.BeanTool;

public class ResponsePage<T> extends BaseResponse {
	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private List<T> list;
	private long total;
	private long pageSize;
	private long pageNum;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponsePage(List list, Class<T> classObj) {
		PageInfo pageInfo = new PageInfo(list);
		this.list = BeanTool.convertList(pageInfo.getList(), classObj);
		this.total = pageInfo.getTotal();
		this.pageSize = pageInfo.getPageSize();
		this.pageNum = pageInfo.getPageNum();
		code = 0;
	}

	public ResponsePage() {
	}

	public boolean hasPrevious() {
		return this.pageNum > 1L;
	}

	public boolean hasNext() {
		return this.pageNum < this.getPages();
	}

	public long getPages() {
		if (this.getPageSize() == 0L) {
			return 0L;
		} else {
			long pages = this.getTotal() / this.getPageSize();
			if (this.getTotal() % this.getPageSize() != 0L) {
				++pages;
			}

			return pages;
		}
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public long getPageNum() {
		return pageNum;
	}

	public void setPageNum(long pageNum) {
		this.pageNum = pageNum;
	}

}
