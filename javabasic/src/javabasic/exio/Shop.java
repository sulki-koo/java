package javabasic.exio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Shop implements Serializable {
	private static final long serialVerisonUID = 564978321564123L;
	private String name; // 상점명
	private List<Product> productList; // 제품리스트

	public Shop() {
	}

	public Shop(String name, List<Product> productList) {
		super();
		this.name = name;
		this.productList = productList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return name + "상점의 제품 리스트:" + productList;
	}

}