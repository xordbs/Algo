package com.ssafy.abc;

public interface IProductMgr {
	
	void add(Product p);

	Product[] list();

	Product list(int num);

	Product[] searchByName(String str);

	Tv[] searchByTv();

	Refrigerator[] searchByRefrigerator();

	Refrigerator[] searchByRefrigerator400L();

	Tv[] searchByTv50inch();

	void changePrice(int num, int price);

	void delete(int num);

	int getTotalPrice();

	void priceList(int price);

}
