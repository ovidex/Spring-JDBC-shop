package com.db.school.demo.order;

import com.db.school.demo.customer.Customer;
import com.db.school.demo.customer.CustomerServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceContract orderService;

    @GetMapping("/all")
    public List<Order> getOrders(){
        return orderService.getOrders();
    }
    @GetMapping
    public Order getOrder(@RequestParam("id") int id){
        return orderService.getOrder(id);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }
    @PostMapping("/update")
    public Order updateOrder(@RequestParam("id") int id,@RequestBody Order order){
        return orderService.updateOrder(id,order);
    }

    @PostMapping("/delete")
    public int deleteOrder(@RequestParam("id") int id){
        return orderService.deleteOrder(id);
    }
}
