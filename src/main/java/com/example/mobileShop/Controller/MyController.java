package com.example.mobileShop.Controller;


import com.example.mobileShop.Entity.Manufacturer;
import com.example.mobileShop.Entity.Product;
import com.example.mobileShop.Service.ManufacturerService;
import com.example.mobileShop.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ManufacturerService manufacturerService;

    @RequestMapping("/")
    public String homePage(Model model, @Param("keyword") String keyword){
       List<Product> listProducts = productService.listAll(keyword);
       model.addAttribute("listProducts", listProducts);
        return "homePage";
    }

    @RequestMapping("/new")
    public  String showNewProductForm(Model model){
        Product product = new Product();
       Manufacturer manufacturer = new Manufacturer();
       product.setManufacturer(manufacturer);
        model.addAttribute("product",product);
        model.addAttribute("manufacturer", manufacturer);
        return "new_product";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product,
                             @ModelAttribute("manufacturer") Manufacturer manufacturer){

    Manufacturer manufacturer1 = manufacturerService.findByBrand(manufacturer.getBrand());
    product.setManufacturer(manufacturer1);
    productService.save(product);
      return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id){
         ModelAndView mav = new ModelAndView("edit_product");

         Product product = productService.getById(id);
         Manufacturer manufacturer = product.getManufacturer();
         mav.addObject("product", product);
         mav.addObject("manufacturer", manufacturer);

         return mav;
    }


    @RequestMapping("/delete/{id}")
    public String DeleteProduct(@PathVariable(name = "id") Long id){
        productService.deleteById(id);
        return "redirect:/";
    }
}
