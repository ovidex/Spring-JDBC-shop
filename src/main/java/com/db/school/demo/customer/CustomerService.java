package com.db.school.demo.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public CustomerService(){
        System.out.println("Constructor!");
    }

    public Customer createCustomer(Customer customer){
        System.out.println(customer);
        return customer;
    }

    public Customer getCustomer(int id){
        return new Customer(id, "CatalinStircu", "Alex", "Catalin", "0774544179",
                "Strada Izvor", "Constanta", "900365", "Romania");
    }

}
