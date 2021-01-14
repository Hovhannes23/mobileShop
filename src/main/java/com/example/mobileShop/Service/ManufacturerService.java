package com.example.mobileShop.Service;

import com.example.mobileShop.Entity.Manufacturer;
import com.example.mobileShop.Entity.Product;
import com.example.mobileShop.Repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService  {

    @Autowired
    ManufacturerRepository repo;

    public List<Manufacturer> listAll(){
        return repo.findAll();
    }

    public void save(Manufacturer manufacturer){
        repo.save(manufacturer);
    }

    public Manufacturer getById(Long id){
        return  repo.findById(id).get();
    }

    public void deleteById(Long id){
        repo.deleteById(id);
    }

    public Manufacturer findByBrand(String brand){
       Manufacturer manufacturer = repo.findByBrand(brand);
       return manufacturer;
    }

}
