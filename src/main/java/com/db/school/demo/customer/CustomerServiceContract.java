package com.db.school.demo.customer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public interface CustomerServiceContract {
    public Customer createCustomer(Customer customer);
    public Customer getCustomer(int id);
    public List<Customer> getCustomers();
    public Customer updateCustomer(int id,Customer customer);
    public int deleteCustomer(int id);
}
