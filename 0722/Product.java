package com.ssafy.abc;

public class Product {
	private String sn;
	private String name;
	private int price;
	private int qty;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "SN = " + sn + ", Name = " + name + ", Price = " + price + ", Qty = " + qty+", ";
	}
	
	
}
