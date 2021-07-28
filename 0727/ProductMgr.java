package com.ssafy.abc;

import java.util.Arrays;

public class ProductMgr {
	private int max = 100;
	private Product[] pro = new Product[max];
	private int size;
	
	public void menu() {
		System.out.println("메뉴를 선택하세요");
		System.out.println("1. 상품추가");
		System.out.println("2. 상품삭제");
		System.out.println("3. 상품보기");
		System.out.println("4. 상품검색");
		System.out.println("5. 가격검색");
	}
	
	public void add(Product p) {
		pro[size] = p;
		size++;
		System.out.println( "상품번호 "+ p.getNum() + "번 상품이 등록되었습니다.");
	}
	// 상품 전체 조회
	public void list() {
		for (int i = 0; i < size; i++) {
			System.out.println(pro[i]);
		}
	}
	// 상품 번호 조화
	public void list(int num) {
		for (int i = 0; i < size; i++) {
			if(pro[i].getNum() == num) {
				System.out.println(pro[i]);
			}
		}
	}
	// 상품명 검색(부분 검색 가능)
	public Product[] searchByName(String str) {
		Product[] b = new Product[size];
		int index = 0;
		for (int i = 0; i < size; i++) {
			if(pro[i].getName().indexOf(str) != -1) {
				b[index++] = pro[i];
			}
		}
		return Arrays.copyOfRange(b, 0, index);
	}
	// tv 상품만 조회
	public Tv[] searchByTv() {
		Tv[] b = new Tv[size];
		int index = 0;
		for (int i = 0; i < pro.length; i++) {
			if(pro[i] instanceof Tv) {
				b[index++] = (Tv)pro[i];
			}
		}
		return Arrays.copyOfRange(b, 0, index);
	}
	
	// 냉장고 상품만 조회
	public Refrigerator[] searchByRefrigerator() {
		Refrigerator[] b = new Refrigerator[size];
		int index = 0;
		for (int i = 0; i < pro.length; i++) {
			if(pro[i] instanceof Refrigerator) {
				b[index++] = (Refrigerator)pro[i];
			}
		}
		return Arrays.copyOfRange(b, 0, index);
	}
	
	// 상품 삭제
	public void delete(int num) {
		int removeIdx = -1;
		for(int i = 0; i < size; i++) {
			if(pro[i].getNum() == num) {
				removeIdx = i;
				break;
			}
		}
		if(removeIdx>-1) {
			pro[removeIdx] = pro[size-1];
			pro[size-1] = null;
			size--;
			System.out.println("상품번호 "+  num + "번 상품이 삭제되었습니다.");
		}
	}
	
	public int getTotalPrice() {
		int total = 0;
		for (int i = 0; i < size; i++) {
			total += (pro[i].getPrice() * pro[i].getQty());
		}
		return total;
	}
	
	public void priceList(int price) {
		for (int i = 0; i < size; i++) {
			if(pro[i].getPrice() <= price) {
				System.out.println(pro[i]);
			}
		}
	}
}
