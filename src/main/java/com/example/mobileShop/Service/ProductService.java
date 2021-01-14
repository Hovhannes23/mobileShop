package com.example.mobileShop.Service;


import com.example.mobileShop.Entity.Product;
import com.example.mobileShop.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> listAll(String keyword){
        if(keyword!=null) {
            return repo.findAll(keyword);
        }
        return repo.findAll();
    }

    public void save(Product product){
        repo.save(product);
    }

    public Product getById(Long id){
        return  repo.findById(id).get();
    }

    public void deleteById(Long id){
        repo.deleteById(id);
    }

}
