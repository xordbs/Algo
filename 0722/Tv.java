package com.ssafy.abc;

public class Tv extends Product{

	private int size;
	private String type;
	
	public Tv() {
	}
	

	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return super.toString() + "size = "+size+", type="+type;
	}
	
	
	
}
