package com.ssafy.abc;

import java.util.Scanner;


public class ProductTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductMgr pm = new ProductMgr();
		
		pm.add(new Tv(1, "삼성올레드", 1500000, 10, 43, "OLED"));
		pm.add(new Tv(2, "엘지올레드", 1700000, 8, 50, "OLED"));
		pm.add(new Refrigerator(3, "삼성비스포크", 2300000, 6, 230));
		pm.add(new Refrigerator(4, "엘지오브제", 2100000, 20, 230));
		
		System.out.println("-------------------------상품검색-------------------------");
		pm.list();
		System.out.println();
		
		System.out.println("--------------------상품 번호 검색 : 1--------------------");
		pm.list(1);
		System.out.println();
		
		System.out.println("--------------------상품명 검색 : 삼성--------------------");
		for (Product b : pm.searchByName("삼성")) {
			System.out.println(b);
		}
		System.out.println();
		
		System.out.println("----------------------- TV 상품검색 ----------------------");
		for (Tv b : pm.searchByTv()) {
			System.out.println(b);
		}
		System.out.println();
		
		System.out.println("--------------------- 냉장고 상품검색 --------------------");
		for (Refrigerator b : pm.searchByRefrigerator()) {
			System.out.println(b);
		}
		System.out.println();
		
		System.out.println("--------------------상품 삭제 : 2--------------------");
		pm.delete(2);
		System.out.println();
		
		System.out.println("--------------------상품 재고 전체 금액--------------------");
		System.out.println(pm.getTotalPrice() + "원");
		System.out.println();
		
		
		
		
		
	} // end of main
} // end of class
