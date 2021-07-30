package com.ssafy.happyhouse.model.dto;

public class Shop {
	
	private String name;
	private String sort;
	private String addr;
	
	public Shop() {}
	
	public Shop(String name, String sort, String addr) {
		this.name = name;
		this.sort = sort;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "Shop [name=" + name + ", sort=" + sort + ", addr=" + addr + "]";
	}
	
	
	

}
