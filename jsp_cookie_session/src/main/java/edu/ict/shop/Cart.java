package edu.ict.shop;

import java.util.ArrayList;

public class Cart {
	private ArrayList<String> productList;
	
	public Cart() {
		productList = new ArrayList<String>();
		productList.add("���̴�");
		productList.add("�ݶ�");
		productList.add("���");
	}
	
	public ArrayList<String> getProductList() {
		return productList;
	}
}
