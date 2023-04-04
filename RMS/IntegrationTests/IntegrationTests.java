package IntegrationTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import GUI.Main;
import orderManagement.Order;
import orderManagement.OrderHelper;
import restaurantManagement.Employee;
import restaurantManagement.Manager;

class IntegrationTests {
	
	Manager manager;
	OrderHelper orderHelper;
	Order order;
	
	@BeforeEach
	void setUp() throws Exception {
		manager = new Manager();
		orderHelper = Main.orderHelper;
		order = new Order();
	}

	@Test
	void managerAddCook1() {
		manager.addCook("Julia", 10000);
		assertEquals("Julia", manager.getEmployees().get(manager.getEmployees().size()-1).getName());
	}
	
	@Test
	void managerAddWaiter1() {
		manager.addWaiter("Matt", 5000);
		assertEquals("Matt", manager.getEmployees().get(manager.getEmployees().size()-1).getName());	
	}
	
	@Test
	void managerAddCookTestId() {
		int sz = manager.getEmployees().size();
		manager.addCook("Julia", 10000);
		manager.addCook("Justin", 15000);
		
		boolean testResult = true;
		
		for(int i = sz; i < manager.getEmployees().size(); i++) {
			if(manager.getEmployees().get(i).getId()!=(i+1))
				testResult = false;
		}
		assertTrue(testResult);
	}
	
	@Test
	void managerAddWaiterTestId() {
		int sz = manager.getEmployees().size();
		manager.addWaiter("Matt", 5000);
		manager.addWaiter("Zach", 6000);
		
		boolean testResult = true;
		
		for(int i = sz; i < manager.getEmployees().size(); i++) {
			if(manager.getEmployees().get(i).getId()!=(i+1))
				testResult = false;
		}
		assertTrue(testResult);
	}
	
	@Test
	void managerAddMixedTestId() {
		int sz = manager.getEmployees().size();
		manager.addWaiter("Julia", 10000);
		manager.addCook("Matt", 5000);
		
		boolean testResult = true;
		
		for(int i = sz; i < manager.getEmployees().size(); i++) {
			if(manager.getEmployees().get(i).getId()!=(i+1))
				testResult = false;
		}
		assertTrue(testResult);
	}
	
	@Test
	void employeeInitTest1() {
		boolean testResult = true;
		for(int i = 0; i < manager.getEmployees().size(); i++) {
			if(manager.getEmployees().get(i).getId()!=(i+1))
				testResult = false;
		}
		assertTrue(testResult);
	}

	@Test
	void employeeInitTest2() {
		
		assertTrue("Monica" == manager.getEmployees().get(0).getName() &&
				   "Ross" == manager.getEmployees().get(1).getName() &&
				   "Phobe" == manager.getEmployees().get(2).getName() &&
				   "Rachel" == manager.getEmployees().get(3).getName());
	}
	
	@Test
	void productInitTest() {
		
		assertTrue("Pizza" == manager.getProducts().get(0).getName() &&
				   "Burger" == manager.getProducts().get(1).getName() &&
				   "Coke" == manager.getProducts().get(2).getName() &&
				   "Lemonade" == manager.getProducts().get(3).getName());
	}
	
	@Test
	void managerCalculateExpense1() {
		manager.addCook("Julia", 10000);
		manager.addWaiter("Matt", 5000);
		assertEquals(1.18*(5000+1000+2000+3000+10000+5000),manager.calculateExpenses());
		//Fails only when all of the tests are being run because it gets affected by other methods which create another order
	}
	
	
	@Test
	void managerCalculateExpense2() {
		manager.addCook("Julia", 10000);
		manager.addWaiter("Matt", 5000);
		order.addProduct(manager.getProducts().get(0));
		order.addProduct(manager.getProducts().get(1));
		orderHelper.createOrder(order);
		assertEquals((1.18*(5000+1000+2000+3000+10000+5000)+2+1.5+2+2),manager.calculateExpenses());
		//Fails only when all of the tests are being run because it gets affected by other methods which create another order
	}
	
	@Test
	void managerCalculateRevenue() {
		order.addProduct(manager.getProducts().get(0));
		order.addProduct(manager.getProducts().get(1));
		orderHelper.createOrder(order);
		assertEquals(5+6,manager.calculateRevenue());
		//Fails because it gets affected by managerCalculateExpenses2 method where we created another order
	}
	
	
	
}
