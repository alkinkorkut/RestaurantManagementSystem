package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import databaseManagement.EmployeeDatabase;

import restaurantManagement.Employee;
import restaurantManagement.Waiter;

class EmployeeDatabaseUnitTest {

	EmployeeDatabase employeeDatabase;
	Employee employee1;
	Employee employee2;
	Employee employee3;
	
	@BeforeEach
	void setUp() throws Exception {		
		employeeDatabase = new EmployeeDatabase();
		employee1 = new Waiter(1, "Jane",3000 );
		employee2 = new Waiter(2, "Smith",25000 );
		employee3 = new Waiter(3, "Lisa",3500 );
	}

	@Test
	void testSingleAddEmployee() {
		employeeDatabase.add(employee1);
		assertEquals(employee1, employeeDatabase.getAllEmployee().get(0));
	}
	
	@Test
	void testMultiAddEmployee() {
		employeeDatabase.add(employee1);
		employeeDatabase.add(employee2);
		employeeDatabase.add(employee3);

		boolean testResult = true;
		int count = 0;
		for (Employee employee : employeeDatabase.getAllEmployee()) {
			if(employee != employeeDatabase.getAllEmployee().get(count)) {
				testResult = false;
			}
			count ++;
		}
		assertTrue(testResult);
	}
	

}
