package com.db.school.demo.customer;

public interface CustomerServiceContract {
    public Customer createCustomer(Customer customer);
    public Customer getCustomer(int id);
}
