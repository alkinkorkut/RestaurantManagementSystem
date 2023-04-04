package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import restaurantManagement.Waiter;

class WaiterUnitTests {

	private Waiter waiter;
	
	@BeforeEach
	void setUp() throws Exception {
		waiter = new Waiter(0, "Jacob", 100000);
	}

	@Test
	void setGetWaiterTest1() {
		waiter.setId(1);
		assertEquals(waiter.getId(), 1);
	}
	@Test
	void setGetWaiterTest2() {
		waiter.setName("Corey");
		assertEquals(waiter.getName(), "Corey");
	}
	
	@Test
	void setGetWaiterTest3() {
		waiter.setSalary(100000);
		assertEquals(waiter.getSalary(), 100000);
	}
	
	@Test
	void testWaiterCalculateExpenses() {
		assertEquals(waiter.calculateExpense(), 100000+100000*0.18);
	}
	
	@Test
	void testWaiterToString(){
		assertEquals(waiter.toString(), "Waiter 0: Jacob");
	}
	
	
}
