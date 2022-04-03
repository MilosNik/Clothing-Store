package rs.milnik;

import java.util.ArrayList;

public class Cart {

	private ArrayList<Product> productList;

	public Cart() {
		super();
		this.productList = new ArrayList<Product>();
	}

	public void addToCart(Product product) {
		this.productList.add(product);
	}

	public ArrayList<Product> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}

}
