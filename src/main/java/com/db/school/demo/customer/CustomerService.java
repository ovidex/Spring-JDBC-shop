package com.db.school.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements CustomerServiceContract {

    @Autowired
    private JdbcTemplate template;

    public Customer createCustomer(Customer customer){
        String str="INSERT INTO CUSTOMERS(`id`, `username`, `last_name`, `first_name`, `phone`, `address`, `city`, `postalcode`, `country`) values(?,?,?,?,?,?,?,?,?)";
        int customer1=template.update(str,customer.getId(),customer.getUsername(),customer.getLastName(),customer.getFirstName(),customer.getPhone(),customer.getAddress(),customer.getCity(),customer.getPostalCode(),customer.getCountry());

        System.out.println(customer);
        return customer;
    }
    public Customer updateCustomer(int id,Customer customer){
        Customer customer1 = template.queryForObject("SELECT * FROM customers WHERE id = " + id, new CustomerMapper());
        String string="UPDATE customers SET phone =? ,address=? , username=? WHERE id= "+id;
        int x=template.update(string,customer.getPhone(),customer.getAddress(),customer.getUsername());
        return customer;
    }
     public int deleteCustomer(int id){
        int x = template.update("DELETE FROM customers WHERE id = " + id);
        return x;
    }

    public Customer getCustomer(int id){
        Customer customer = template.queryForObject("SELECT * FROM customers WHERE id =" + id, new CustomerMapper());
        System.out.println(customer);
        return customer;
    }
    public List<Customer> getCustomers(){
        List<Customer> customers = (ArrayList<Customer>) template.query("SELECT * FROM customers", new CustomerMapper());
        System.out.println(customers);
        return customers;
    }



}
