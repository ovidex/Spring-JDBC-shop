package com.db.school.demo.order;

import com.db.school.demo.customer.Customer;
import com.db.school.demo.customer.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements OrderServiceContract{

    @Autowired
    private JdbcTemplate template;

    public Order createOrder(Order order){
        String str="INSERT INTO orders(`id`, order_date,shipped_date,status,comments,customer_id) values(?,?,?,?,?,?)";
        int order1=template.update(str,order.getId(),order.getOrder_date(),order.getShipped_date(),order.getStatus(),order.getComments(),order.getCustomer_id());

        System.out.println(order);
        return order;
    }
    public Order updateOrder(int id,Order order){
        Order order1 = template.queryForObject("SELECT * FROM orders WHERE id = " + id, new OrderMapper());
        String string="UPDATE orders SET status=? WHERE id= "+id;
        int x=template.update(string,order.getStatus());
        return order;
    }
    public int deleteOrder(int id){
        int x = template.update("DELETE FROM orders WHERE id = " + id);
        return x;
    }

    public Order getOrder(int id){
        Order order = template.queryForObject("SELECT * FROM orders WHERE id =" + id, new OrderMapper());
        System.out.println(order);
        return order;
    }
    public List<Order> getOrders(){
        List<Order> orders = (ArrayList<Order>) template.query("SELECT * FROM orders", new OrderMapper());
        System.out.println(orders);
        return orders;
    }


}
