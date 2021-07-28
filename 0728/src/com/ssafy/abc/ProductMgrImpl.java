package com.ssafy.abc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class ProductMgrImpl implements IProductMgr {

	List<Product> products = new ArrayList<>();
	
	private static IProductMgr instance  = new ProductMgrImpl();
	private ProductMgrImpl() {
		
	}
	public static IProductMgr getInstance() {
		return instance;
	}
	
	@Override
	public void add(Product p) {
		products.add(p);
		System.out.println( "상품이 등록되었습니다.");
	}
	// 상품 전체 조회
	@Override
	public Product[] list() {
		Product[] result = new Product[products.size()];
		return products.toArray(result);
	}
	
	// 상품 번호 조회
	@Override
	public Product list(int num) {
		for (Product product : products) {
			if(product.getNum() == num) return product;
		}
		return null;
	}
	
	// 상품명 검색(부분 검색 가능)
	@Override
	public Product[] searchByName(String str) {
		List<Product> p = new ArrayList<Product>();
		for (Product product : products) {
			if(product.getName().contains(str))  p.add(product);
			
		}
		Product[] result = new Product[p.size()];
		return p.toArray(result);
	}
	
	// tv 상품만 조회
	@Override
	public Tv[] searchByTv() {
		List<Tv> p = new ArrayList<Tv>();
		for (Product product : products) {
			if(product instanceof Tv) p.add((Tv)product);
		}
		Tv[] result = new Tv[p.size()];
		return p.toArray(result);
	}
	
	// 냉장고 상품만 조회
	@Override
	public Refrigerator[] searchByRefrigerator() {
		List<Refrigerator> p = new ArrayList<Refrigerator>();
		for (Product product : products) {
			if(product instanceof Refrigerator) p.add((Refrigerator)product);
		}
		Refrigerator[] result = new Refrigerator[p.size()];
		return p.toArray(result);
	}
	
	// 400L 이상 냉장고 검색
	@Override
	public Refrigerator[] searchByRefrigerator400L() {
		List<Refrigerator> p = new ArrayList<Refrigerator>();
		for (Product product : products) {
			if(product instanceof Refrigerator) {
				if(((Refrigerator) product).getL() >= 400)  p.add((Refrigerator)product);
			}
		}
		Refrigerator[] result = new Refrigerator[p.size()];
		return p.toArray(result);
	}	
	
	// 50인치 이상 tv 상품만 조회
	@Override
	public Tv[] searchByTv50inch() {
		List<Tv> p = new ArrayList<Tv>();
		for (Product product : products) {
			if(product instanceof Tv) {
				if(((Tv)product).getSize() >= 50) p.add((Tv)product);
			}
		}
		Tv[] result = new Tv[p.size()];
		return p.toArray(result);
	}
	
	// 상품 번호로 상품 가격 변경
	@Override
	public void changePrice(int num, int price) {
		Product p = list(num);
		p.setPrice(price);
	}
	
	
	// 상품 삭제
	@Override
	public void delete(int num) {
		for(Product product : products) {
			if(product.getNum() == num) {
				products.remove(product);
				break;
			}
		}
	}
	
	@Override
	public int getTotalPrice() {
		int total = 0;
		for (int i = 0; i < products.size(); i++) {
			total += (products.get(i).getPrice() * products.get(i).getQty());
		}
		return total;
	}
	
	@Override
	public void priceList(int price) {
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i).getPrice() <= price) {
				System.out.println(products.get(i));
			}
		}
	}
}
