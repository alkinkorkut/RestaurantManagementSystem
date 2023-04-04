package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import databaseManagement.ProductDatabase;
import orderManagement.Beverage;
import orderManagement.Dessert;
import orderManagement.MainDish;
import orderManagement.Product;

class ProductDatabaseUnitTests {

	ProductDatabase productDatabase;
	Product product1;
	Product product2;
	Product product3;
	
	@BeforeEach
	void setUp() throws Exception {
		productDatabase = new ProductDatabase();
		product1 = new Beverage("Coke", 20, 10, 5);
		product2 = new MainDish("Pasta", 100, 50 ,25);
		product3 = new Dessert("Waffle", 50, 25, 10);
	}

	@Test
	void testSingleAddproduct() {
		productDatabase.add(product1);
		assertEquals(product1, productDatabase.getAllProduct().get(0));
	}
	
	@Test
	void testMultiAddproduct() {
		productDatabase.add(product1);
		productDatabase.add(product2);
		productDatabase.add(product3);

		boolean testResult = true;
		int count = 0;
		for (Product product : productDatabase.getAllProduct()) {
			if(product != productDatabase.getAllProduct().get(count)) {
				testResult = false;
			}
			count ++;
		}
		assertTrue(testResult);
	}

}
