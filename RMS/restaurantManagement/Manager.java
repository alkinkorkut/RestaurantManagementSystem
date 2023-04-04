package restaurantManagement;

import GUI.Main;
import databaseManagement.EmployeeDatabase;
import databaseManagement.ProductDatabase;
import orderManagement.*;

import java.util.ArrayList;
import java.util.Random;


public class Manager {

	private ProductDatabase productDatabase = new ProductDatabase();
	private EmployeeDatabase employeeDatabase = new EmployeeDatabase();
	private ArrayList<Employee> employees = employeeDatabase.getAllEmployee();
	private ArrayList<Product> products = productDatabase.getAllProduct();
	
	public Manager() {
		initEmployees();
		initProducts();
	}
	
	private void initEmployees() {
		addCook("Monica", 5000);
		
		addWaiter("Ross", 1000);
		addWaiter("Phobe", 2000);
		addWaiter("Rachel", 3000);
	}
	
	private void initProducts() {
		
		// Parameters for Product Constructor:
		// Product Name, Selling Price, Purchase Price and Utility Cost

		productDatabase.add(new MainDish("Pizza", 6, 2, 2));
		productDatabase.add(new MainDish("Burger", 5, 1.5, 2));
		productDatabase.add(new Beverage("Coke", 2, 0.5, 0));
		productDatabase.add(new Beverage("Lemonade", 2, 0.3, 0));
		productDatabase.add(new Dessert("Tiramusu", 4, 1, 1));
		productDatabase.add(new Dessert("Cake", 3, 0.5, 1));
		productDatabase.add(new Dessert("Ice Cream", 3, 0.5, 0.5));
		
		ArrayList<Product> HGproducts = new ArrayList<>();
		HGproducts.add(new MainDish("Pizza", 6, 2, 2));
		HGproducts.add(new Beverage("Coke", 2, 0.5, 0));
		HGproducts.add(new Dessert("Tiramusu", 4, 1, 1));
		productDatabase.add(new MenuProduct("Hunger Games Menu", HGproducts));
		
		ArrayList<Product> Kidsproducts = new ArrayList<>();
		Kidsproducts.add(new MainDish("Burger", 5, 1.5, 2));
		Kidsproducts.add(new Beverage("Lemonade", 2, 0.3, 0.2));
		Kidsproducts.add(new Dessert("Ice Cream", 3, 0.5, 0.5));
		productDatabase.add(new MenuProduct("Kids Menu", Kidsproducts));
	}

	public ArrayList<String> listEmployees() {
		ArrayList<String> employeeList = new ArrayList<String>();

		for (int i=0; i<employees.size(); i++) {
			employeeList.add(employees.get(i).toString());
		}
		return employeeList;
	}

	public void addCook(String cook, double salary) {
		employeeDatabase.add(new Cook((employees.size()+1),cook,salary));
		employees = employeeDatabase.getAllEmployee();
	}

	public void addWaiter(String waiter, double salary) {
		employeeDatabase.add(new Waiter((employees.size()+1),waiter,salary /* TODO: Give Salary*/));
		employees = employeeDatabase.getAllEmployee();
	}


	public double calculateEmployeeExpenses() {
		double employeeExpenses=0;
		for(int i=0;i<employees.size();i++) {
			employeeExpenses+=employees.get(i).calculateExpense();
		}
		return employeeExpenses;

	}
	public double calculateOrderExpenses() {
		double orderExpenses=0;
		OrderHelper orderHelper = Main.orderHelper;
		for (int i=0;i<orderHelper.getOrdersReceived().size();i++) {
			Order order = orderHelper.getOrdersReceived().get(i);
			ArrayList<Product> products = order.getOrderedProducts();
			for(Product product: products){
				orderExpenses += product.getUtilityCost();
				orderExpenses += product.getPurchasePrice();
			}
		}
		return orderExpenses;
	}
	public double calculateExpenses() { 
		double employeeExpenses= calculateEmployeeExpenses();
		double orderExpenses= calculateOrderExpenses();
		double totalExpenses=0;

		 totalExpenses= employeeExpenses+orderExpenses;
		return totalExpenses;
	}

	public double calculateRevenue() { 
		double sum=0;

		OrderHelper orderHelper = Main.orderHelper;
		for (int i=0;i<orderHelper.getOrdersReceived().size();i++) {

			Order order = orderHelper.getOrdersReceived().get(i);
			ArrayList<Product> products = order.getOrderedProducts();
			for(Product product: products){
				sum += product.getSellingPrice();
			}
		}
		return sum;
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}
	
	public ArrayList<Employee> getEmployees(){
		return employees;
	}
	
	

}
