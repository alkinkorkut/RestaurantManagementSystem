

package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import GUI.Main;
import orderManagement.Beverage;
import orderManagement.MainDish;
import orderManagement.Order;
import orderManagement.OrderHelper;

class OrderHelperUnitTests {

	OrderHelper orderHelper;
	Order order1;
	Order order2;
	Beverage beverage;
	MainDish mianDish;
	
	@BeforeEach
	void setUp() throws Exception {
		order1 = new Order();
		order2 = new Order();
		orderHelper = Main.orderHelper;
		order1.addProduct(beverage);
		order2.addProduct(mianDish);
		
		orderHelper.createOrder(order1);
		orderHelper.createOrder(order2);
		
	}

	@Test
	void testGetOrdersRecieved() {
		assertTrue( order1 == orderHelper.getOrdersReceived().get(0) && order2 == orderHelper.getOrdersReceived().get(1));
	}
}

