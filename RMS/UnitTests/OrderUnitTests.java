package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import orderManagement.Beverage;
import orderManagement.Dessert;
import orderManagement.MainDish;
import orderManagement.MenuProduct;
import orderManagement.Order;
import orderManagement.Product;

class OrderUnitTests {
	private MenuProduct menuProduct;
	private MainDish mainDish;
	private Beverage beverage;
	private Dessert dessert;
	private ArrayList<Product> products;
	private Order order;
	@BeforeEach
	void setUp() throws Exception {
		mainDish = new MainDish("Beef", 500, 300, 100);
		beverage = new Beverage("Ice Tea", 20, 10 , 5 );
		dessert = new Dessert("Cake", 200, 100, 50);
		products = new ArrayList<Product>();
		products.add(beverage);
		products.add(mainDish);
		products.add(dessert);
		menuProduct = new MenuProduct("King Menu", products);
		order = new Order();
		order.addProduct(menuProduct);
		order.addProduct(beverage);
		order.addProduct(dessert);
		order.addProduct(mainDish);
	}

	@Test
	void testGetOrderedProducts() {
		
		
		assertTrue(order.getOrderedProducts().get(3).getName() == "Beef" &&
				   order.getOrderedProducts().get(1).getName() == "Ice Tea" &&
				   order.getOrderedProducts().get(2).getName() == "Cake" &&
				   order.getOrderedProducts().get(0).getName() == "King Menu");
	}
	
	@Test
	void testGetTotalPrice() {
		assertEquals(500+20+200+menuProduct.getSellingPrice(),order.calculateTotalPrice());
	}

}
