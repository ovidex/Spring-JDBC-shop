package com.db.school.demo.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    @GetMapping("/customer")
    String getCustomer(){
        return "Succes";
    }
}

