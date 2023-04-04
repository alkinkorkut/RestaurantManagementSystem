package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import orderManagement.Beverage;


class BeverageUnitTests {

	private Beverage beverage;
	
	@BeforeEach
	void setUp() throws Exception {
		beverage = new Beverage("Ice Tea", 20, 10, 5);
	}

	@Test
	void setGetBeverageTest1() {
		beverage.setName("Coke");
		assertEquals(beverage.getName(), "Coke");
	}
	@Test
	void setGetBeverageTest2() {
		beverage.setSellingPrice(30);
		assertEquals(30, beverage.getSellingPrice());
	}
	
	@Test
	void setGetBeverageTest3() {
		assertEquals(10, beverage.getPurchasePrice());
	}
	
	@Test
	void setGetBeverageTest4() {
		assertEquals(5, beverage.getUtilityCost());
	}
	
	@Test
	void beverageCalculateExpenses() {
		assertEquals(10+5,beverage.calculateExpense());
	}
	
	@Test
	void beverageToString(){
		assertEquals("Beverage: Ice Tea", beverage.toString());
	}
	
	
}
