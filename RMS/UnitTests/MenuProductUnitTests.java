package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import orderManagement.Product;
import orderManagement.Beverage;
import orderManagement.Dessert;
import orderManagement.MainDish;
import orderManagement.MenuProduct;


class MenuProductUnitTests {

	private MenuProduct menuProduct;
	private MainDish mainDish;
	private Beverage beverage;
	private Dessert dessert;
	private ArrayList<Product> products;
	
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
	}

	@Test
	void setGetMenuProductTest1() {
		menuProduct.setName("Queen Menu");
		assertEquals("Queen Menu", menuProduct.getName() );
	}
	@Test
	void setGetMenuProductTest2() {
		products.add(new Beverage("Latte",25,15,5));
		menuProduct.setMenuProducts(products);
		boolean testResult = true;   
		for(int i = 0; i<products.size(); i++) {
			if(menuProduct.getMenuProducts().get(i).getName() != products.get(i).getName()) {
				testResult = false;
			}
		}
		assertTrue(testResult);
	}

	
	@Test
	void menuProductGetSellingPrice1() {
		assertEquals((500*0.9+200*0.8+20*0.5) ,menuProduct.getSellingPrice());
	}
	
	@Test
	void menuProductCalculateExpense() {
		assertEquals(300+10+100+100+5+50,menuProduct.calculateExpense());
	}
	
	@Test
	void menuProductToString(){
		assertEquals("King Menu", menuProduct.toString());
	}
	
	
}
