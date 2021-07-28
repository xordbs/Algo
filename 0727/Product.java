package com.ssafy.abc;

public class Product {
	private int num;
	private String name;
	private int price;
	private int qty;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}


	public Product(int num, String name, int price, int qty) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
		this.qty = qty;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
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
		return "SN = " + num + ", Name = " + name + ", Price = " + price + ", Qty = " + qty+", ";
	}
	
	
}
