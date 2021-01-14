package com.example.mobileShop.Repository;

import com.example.mobileShop.Entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ManufacturerRepository extends JpaRepository<Manufacturer,Long> {

    @Query("select m from Manufacturer m where m.brand = :brand")
    Manufacturer findByBrand(@Param("brand")String brand);

}
