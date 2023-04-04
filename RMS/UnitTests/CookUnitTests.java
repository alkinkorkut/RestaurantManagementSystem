package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import restaurantManagement.Cook;

class CookUnitTests {

	private Cook cook;
	
	@BeforeEach
	void setUp() throws Exception {
		cook = new Cook(2, "William", 100000);
	}

	@Test
	void setGetCookTest1() {
		cook.setId(3);
		assertEquals(cook.getId(), 3);
	}
	@Test
	void setGetCookTest2() {
		cook.setName("Daniel");
		assertEquals(cook.getName(), "Daniel");
	}
	
	@Test
	void setGetCookTest3() {
		cook.setSalary(200000);
		assertEquals(cook.getSalary(), 200000);
	}
	
	@Test
	void testCookCalculateExpenses() {
		assertEquals(cook.calculateExpense(), 100000+100000*0.18);
	}
	
	@Test
	void testCookToString(){
		assertEquals(cook.toString(), "Cook 2: William");
	}
	
}
