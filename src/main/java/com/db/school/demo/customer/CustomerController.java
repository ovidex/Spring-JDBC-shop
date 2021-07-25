package com.db.school.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceContract customerService;

    @GetMapping("/all")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }
    @GetMapping
    public Customer getCustomer(@RequestParam("id") int id){
        return customerService.getCustomer(id);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }
    @PostMapping("/update")
    public Customer updateCustomer(@RequestParam("id") int id,@RequestBody Customer customer){
        return customerService.updateCustomer(id,customer);
    }

    @PostMapping("/delete")
    public int deleteCustomer(@RequestParam("id") int id){
        return customerService.deleteCustomer(id);
    }
}

