package cn.ytc.webstore.utils;

import java.util.List;

import cn.ytc.webstore.model.Good;

public class PageInfo {
	private List<Good> pageGoods;
	private int currentPage;
	private int totalPages;
	private long totalItems;
	public List<Good> getPageGoods() {
		return pageGoods;
	}
	public void setPageGoods(List<Good> pageGoods) {
		this.pageGoods = pageGoods;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public long getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(long totalItems) {
		this.totalItems = totalItems;
	}
	public PageInfo(List<Good> pageGoods, int currentPage, int totalPages, long totalItems) {
		super();
		this.pageGoods = pageGoods;
		this.currentPage = currentPage;
		this.totalPages = totalPages;
		this.totalItems = totalItems;
	}
	
	
	
}
