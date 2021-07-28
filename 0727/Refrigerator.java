package com.ssafy.abc;

public class Refrigerator extends Product {
	private int l;
	
	public Refrigerator() {
		
	}
	
	public Refrigerator(int num, String name, int price, int qty, int l) {
		super(num, name, price, qty);
		this.l = l;
	}

	public int getL() {
		return l;
	}
	public void setL(int l) {
		this.l = l;
	}

	@Override
	public String toString() {
		return super.toString() + "Liter = " + l ;
	}


	
	
}
