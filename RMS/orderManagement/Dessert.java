package orderManagement;

public class Dessert implements Product{
	private String name;
	private double purchasePrice;
	private double sellingPrice;
	private double utilityCost;

	public Dessert(String name, double sellingPrice, double purchasePrice, double utilityCost) {
		this.name = name;
		this.sellingPrice = sellingPrice;
		this.purchasePrice = purchasePrice;
		this.utilityCost = utilityCost;
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
		return this.purchasePrice;
	}

	@Override
	public double getSellingPrice() {
		return this.sellingPrice;
	}

	@Override
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	@Override
	public double getUtilityCost() {
		return this.utilityCost;
	}

	public double calculateExpense() {
		return this.getPurchasePrice()+this.getUtilityCost();
	}

	public String toString() {
		return "Dessert: " + this.getName();
	}

}
