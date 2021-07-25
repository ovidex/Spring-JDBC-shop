package com.db.school.demo.order;

import java.util.List;

public interface OrderServiceContract {
    Order updateOrder(int id, Order customer);

    Order createOrder(Order customer);

    List<Order> getOrders();

    Order getOrder(int id);

    int deleteOrder(int id);
}
