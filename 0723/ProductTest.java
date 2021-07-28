package com.ssafy.abc;

import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductMgr pm = new ProductMgr();
		while(true){
			Product p = new Product();
			pm.menu();
			System.out.println();
			int key = sc.nextInt();
			if(key < 1 && 5 < key) {
				System.out.println("올바르지 않습니다. 다시 시도해 주세요.");
			}
			switch (key) {
			case 1: 
				p.setNum(sc.nextInt());
				p.setName(sc.next());
				p.setPrice(sc.nextInt());
				p.setQty(sc.nextInt());
				pm.add(p);
				break;
			case 2: 
				pm.delete(sc.nextInt());
				break;
			case 3:
				pm.list();
				break;
			case 4:
				pm.list(sc.nextInt());
				break;
			case 5:
				pm.priceList(sc.nextInt());
				break;
			}
		}
		
	} // end of main
} // end of class
