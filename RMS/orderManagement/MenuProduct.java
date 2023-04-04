package orderManagement;

import java.util.ArrayList;

public class MenuProduct implements Product {
	private String name;
	private ArrayList<Product> menuProducts;


	public MenuProduct(String name, ArrayList products) {
		this.name = name;
		this.menuProducts = products;
	}

	public ArrayList<Product> getMenuProducts() {
		return menuProducts;
	}

	public void setMenuProducts(ArrayList<Product> menuProducts) {
		this.menuProducts = menuProducts;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public double getPurchasePrice() {
		return 0;
	}

	public double getSellingPrice() {
		double sum=0;
		for(int i=0; i<menuProducts.size();i++) {
			if(menuProducts.get(i) instanceof MainDish) {
				sum= sum+ (menuProducts.get(i)).getSellingPrice()*(0.9);
			} if(menuProducts.get(i)instanceof Dessert) {
				sum= sum+ (menuProducts.get(i)).getSellingPrice()*(0.8);
			}if (menuProducts.get(i) instanceof Beverage){
				sum= sum +(menuProducts.get(i)).getSellingPrice()*(0.5);
			}
		}
		return sum;
	}

	@Override
	public void setSellingPrice(double sellingPrice) {

	}

	@Override
	public double getUtilityCost() {
		return 0;
	}

	public double calculateExpense() {
		double sum=0;
		for(int i=0; i<menuProducts.size();i++) {
			sum+=(menuProducts.get(i)).calculateExpense();
		}
		return sum;
	}

	public String toString() {
		return this.getName();
	}

}
