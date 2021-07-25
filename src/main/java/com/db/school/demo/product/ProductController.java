package com.db.school.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServiceContract productService;

    @GetMapping("/all")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
    @GetMapping
    public Product getProduct(@RequestParam("code") int id){
        return productService.getProduct(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
    @PostMapping("/update")
    public Product updateProduct(@RequestParam("code") int id, @RequestBody Product product){
        return productService.updateProduct(id,product);
    }

    @PostMapping("/delete")
    public int deleteProduct(@RequestParam("code") int id){
        return productService.deleteProduct(id);
    }
}
