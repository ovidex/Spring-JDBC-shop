package com.db.school.demo.product;

import com.db.school.demo.customer.Customer;
import com.db.school.demo.customer.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductServiceContract{

    @Autowired
    private JdbcTemplate template;


    public Product createProduct(Product product) {
        String str="INSERT INTO products(code, `name`, description, stock, price) values(?,?,?,?,?)";
        int x=template.update(str,product.getCode(),product.getName(),product.getDescription(),product.getStock(),product.getPrice());

        System.out.println(product);
        return product;
    }


    public Product getProduct(int id) {
        Product product = template.queryForObject("SELECT * FROM products WHERE code =" + id, new ProductMapper());
        System.out.println(product);
        return product;
    }


    public List<Product> getProducts() {
        List<Product> products = (ArrayList<Product>) template.query("SELECT * FROM products", new ProductMapper());
        System.out.println(products);
        return products;
    }


    public Product updateProduct(int id, Product product) {
        Product product1 = template.queryForObject("SELECT * FROM products WHERE code = " + id, new ProductMapper());
        String string="UPDATE products SET name =? , stock=? , price=? WHERE code= "+id;
        int x=template.update(string,product.getName(),product.getStock(),product.getPrice());
        return product;
    }


    public int deleteProduct(int id) {
        int x = template.update("DELETE FROM products WHERE code = " + id);
        return x;
    }
}
