package com.example.mobileShop.Repository;

import com.example.mobileShop.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%"
           + "OR p.manufacturer.brand LIKE %?1%"
            + "OR p.manufacturer.country LIKE %?1%")
      List<Product> findAll(String keyword);
}
