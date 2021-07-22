package com.db.school.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements CustomerServiceContract {

    @Autowired
    private JdbcTemplate template;

    public Customer createCustomer(Customer customer){
        System.out.println(customer);
        return customer;
    }

    public Customer getCustomer(int id){
        List<Customer> customers = template.query("SELECT * FROM dbschoolhw.customers WHERE id =" + id, new CustomerMapper());
        System.out.println(customers);
        return new Customer(id, "CatalinStircu", "Alex", "Catalin", "0774544179",
                "Strada Izvor", "Constanta", "900365", "Romania");
    }

}
