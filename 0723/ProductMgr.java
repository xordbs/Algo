package com.ssafy.abc;

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
	
	public void list() {
		for (int i = 0; i < size; i++) {
			System.out.println(pro[i]);
		}
	}
	
	public void list(int num) {
		for (int i = 0; i < size; i++) {
			if(pro[i].getNum() == num) {
				System.out.println(pro[i]);
			}
		}
	}
	
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
			System.out.println("상품번호 "+  num + "번 상품이 삭제되었습니다.");
		}
	}
	public void priceList(int price) {
		for (int i = 0; i < size; i++) {
			if(pro[i].getPrice() <= price) {
				System.out.println(pro[i]);
			}
		}
	}
}
