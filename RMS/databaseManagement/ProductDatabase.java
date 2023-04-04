package databaseManagement;

import orderManagement.Product;
import restaurantManagement.Employee;

import java.util.ArrayList;

public class ProductDatabase implements Database{

    ArrayList<Product> products = new ArrayList<Product>();

    @Override
    public void add(Employee employee) {}

    @Override
    public ArrayList<Employee> getAllEmployee() {return null;}

    @Override
    public ArrayList<Product> getAllProduct() {
        return products;
    }
    /*
    @Override
    public void delete(String name) {
        for (int i = 0; i < products.size(); i++) {
            if (name.equals(products.get(i).getName())) {
                products.remove(i);
                break;
            }
        }
        System.out.println("Product with the name " + name + " couldn't be found.");
    }
*/
   /*
    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Employee employee) {

    }
*/   
    @Override
    public void add(Product product) {
        products.add(product);
    }

    /*
    @Override
    public void update(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (product.getName().equals(products.get(i).getName())) {
                products.remove(i);
                this.add(product);
                break;
            }
        }
        System.out.println("Product with the name " + product.getName() + " couldn't be found.");
    } */
}
