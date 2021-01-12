package com.example.mobileShop.Controller;


import com.example.mobileShop.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @Autowired
    private ProductService service;

    @RequestMapping("/")
    public String homePage(){
        return "homePage";
    }
}
