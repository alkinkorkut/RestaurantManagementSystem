package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import orderManagement.MainDish;


class mainDishUnitTests {

	private MainDish mainDish;
	
	@BeforeEach
	void setUp() throws Exception {
		mainDish = new MainDish("Beef", 500, 300, 100);
	}

	@Test
	void setGetMainDishTest1() {
		mainDish.setName("Chicken");
		assertEquals("Chicken", mainDish.getName());
	}
	@Test
	void setGetMainDishTest2() {
		mainDish.setSellingPrice(600);
		assertEquals(600, mainDish.getSellingPrice());
	}
	
	@Test
	void setGetMainDishTest3() {
		assertEquals(300, mainDish.getPurchasePrice());
	}
	
	@Test
	void setGetMainDishTest4() {
		assertEquals(100, mainDish.getUtilityCost());
	}
	
	@Test
	void mainDishCalculateExpenses() {
		assertEquals(300+100,mainDish.calculateExpense());
	}
	
	@Test
	void mainDishToString(){
		assertEquals( "Main Dish: Beef", mainDish.toString());
	}
	
	
}
