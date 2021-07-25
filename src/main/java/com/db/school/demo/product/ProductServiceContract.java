package com.db.school.demo.product;

import com.db.school.demo.customer.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductServiceContract {
    public Product createProduct(Product product);
    public Product getProduct(int id);
    public List<Product> getProducts();
    public Product updateProduct(int id,Product product);
    public int deleteProduct(int id);
}
