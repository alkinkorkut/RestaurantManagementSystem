package orderManagement;

import java.util.ArrayList;

public class OrderHelper {
    private ArrayList<Order> orders= new ArrayList();

    public void createOrder(Order order) {
        orders.add(order);
    }
    public ArrayList<Order> getOrdersReceived() {
        return orders;
    }
}
