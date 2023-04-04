package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import orderManagement.Dessert;


class DessertUnitTests {

	private Dessert dessert;
	
	@BeforeEach
	void setUp() throws Exception {
		dessert = new Dessert("Cake", 200, 100, 50);
	}

	@Test
	void setGetDessertTest1() {
		dessert.setName("Chocolate");
		assertEquals("Chocolate", dessert.getName());
	}
	@Test
	void setGetDessertTest2() {
		dessert.setSellingPrice(300);
		assertEquals(300, dessert.getSellingPrice());
	}
	
	@Test
	void setGetDessertTest3() {
		assertEquals(100, dessert.getPurchasePrice());
	}
	
	@Test
	void setGetDessertTest4() {
		assertEquals(50, dessert.getUtilityCost());
	}
	
	@Test
	void DessertCalculateExpenses() {
		assertEquals(100+50,dessert.calculateExpense());
	}
	
	@Test
	void dessertToString(){
		assertEquals("Dessert: Cake", dessert.toString());
	}
	
	
}
