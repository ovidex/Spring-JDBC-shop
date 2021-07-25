package com.db.school.demo.product;

import com.db.school.demo.customer.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product=new Product();
        product.setCode(rs.getInt("code"));
        product.setName(rs.getString("name"));

        return product;
    }
}