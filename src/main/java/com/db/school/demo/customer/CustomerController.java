package com.db.school.demo.customer;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping
    public Customer getCustomer(@RequestParam("name") String name){
        return new Customer(12, "CatalinStircu", name, "Catalin", "0774544179",
                "Strada Izvor", "Constanta", "900365", "Romania");
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        System.out.println(customer);
        return customer;
    }
}

