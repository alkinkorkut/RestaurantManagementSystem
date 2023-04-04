package orderManagement;

public interface Product  {
	public String getName();
	public void setName(String name);
	public double getPurchasePrice();
	public double getSellingPrice();
	public void setSellingPrice(double sellingPrice);
	public double getUtilityCost();
	public double calculateExpense();
	public String toString();
}
