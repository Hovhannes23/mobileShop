package com.example.mobileShop.Repository;

import com.example.mobileShop.Entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer,Long> {
}