package databaseManagement;

import orderManagement.Product;
import restaurantManagement.Employee;

import java.util.ArrayList;

public interface Database {
    public void add(Employee employee);
    public ArrayList<Employee> getAllEmployee();
    public ArrayList<Product> getAllProduct();
   /*
    public void delete(String name);
    public void delete(int id);
    public void update(Employee employee);
    public void update(Product product);
    */
    public void add(Product product);
    
}
