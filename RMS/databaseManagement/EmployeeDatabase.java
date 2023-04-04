package databaseManagement;

import orderManagement.Product;
import restaurantManagement.Employee;

import java.util.ArrayList;

public class EmployeeDatabase implements Database{

    ArrayList<Employee> employees = new ArrayList<Employee>();
    @Override
    public void add(Employee employee) {
        employees.add(employee);
    }

    @Override
    public ArrayList<Employee> getAllEmployee() {
        return employees;
    }

    @Override
    public ArrayList<Product> getAllProduct() {
        return null;
    }

    /*
    @Override
    public void delete(String name) {

    }

    public void delete(int id){
        for (int i = 0; i < employees.size(); i++) {
            if (id == employees.get(i).getId()) {
                employees.remove(i);
                break;
            }
        }
        System.out.println("Employee with the id " + id + " couldn't be found.");
    }

    @Override
    public void update(Employee employee) {

        for (int i = 0; i < employees.size(); i++) {
            if (employee.getId() == employees.get(i).getId()) {
                employees.remove(i);
                this.add(employee);
                break;
            }
        }
        System.out.println("Employee with the name " + employee.getName() + " couldn't be found.");
    }
   */
    @Override
    public void add(Product product) {

    }

    /*
    @Override
    public void update(Product product) {

    }

*/
}
