package com.ssafy.abc;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tv tv = new Tv();
		Refrigerator re = new Refrigerator();
		
		tv.setSn("43N123");
		tv.setName("SamSung올레드");
		tv.setPrice(2300000);
		tv.setQty(20);
		tv.setSize(43);
		tv.setType("OLED");
		
		re.setSn("100GL13");
		re.setName("비스포크");
		re.setPrice(1500000);
		re.setQty(42);
		re.setL(70);
		
		System.out.println("*********************TV 정보*********************");
		System.out.println(tv.toString());
		System.out.println();
		System.out.println("*******************냉장고 정보*******************");
		System.out.println(re.toString());
	} // end of main

} // end of class
