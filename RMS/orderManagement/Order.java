package orderManagement;

import java.util.ArrayList;

public class Order {
	private ArrayList<Product> orderedProducts = new ArrayList<>();

	public Order() { }

	public void addProduct(Product product) {
		orderedProducts.add(product);
	}


	public ArrayList<Product> listOrder() {
		return orderedProducts;
	}

	public ArrayList<Product> getOrderedProducts() {
		return orderedProducts;
	}
	
	public double calculateTotalPrice() {
		double sum=0;
		for(int i=0; i<orderedProducts.size();i++) {
			sum+=(orderedProducts.get(i)).getSellingPrice();
		}
		return sum;
	}

}
