package Service;

import Entity.Order;

import java.util.List;

public class OrderService {
    private List<Order> orders;
    public OrderService(List<Order> orders) {
        this.orders = orders;
    }

    public void add(Order order) {
        orders.add(order);
    }
}
