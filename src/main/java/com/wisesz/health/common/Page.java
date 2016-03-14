package com.wisesz.health.common;

import java.io.Serializable;
import java.util.List;

public class Page<T extends Serializable> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<T> datas;
	private long total;
	private int page;
	private int pages;
	private int pageSize;

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
