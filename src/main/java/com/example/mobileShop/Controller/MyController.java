package com.example.mobileShop.Controller;


import com.example.mobileShop.Entity.Manufacturer;
import com.example.mobileShop.Entity.Product;
import com.example.mobileShop.Service.ManufacturerService;
import com.example.mobileShop.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ManufacturerService manufacturerService;

    @RequestMapping("/")
    public String homePage(Model model){
        List<Product> listProducts = productService.listAll();

        model.addAttribute("listProducts", listProducts);
        return "homePage";
    }

    @RequestMapping("/new")
    public  String showNewProductForm(Model model){
        Product product = new Product();
        Manufacturer manufacturer = new Manufacturer();
        model.addAttribute("product",product);
        model.addAttribute("manufacturer",manufacturer);
        return "new_product";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product,
                             @ModelAttribute("manufacturer") Manufacturer manufacturer){

        product.setManufacturer(manufacturer);
      productService.save(product);
      manufacturerService.save(manufacturer);

      return "redirect:/";
    }
}
