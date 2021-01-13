package com.example.mobileShop.Entity;


import javax.persistence.*;

@Entity
@Table(name="manufacturers")
public class Manufacturer {

    private Long id_manufacturer;
    private String country;
    private String email;
    private String brand;

public Manufacturer(){

}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manufacturer_id")
    public Long getId_manufacturer() {
        return id_manufacturer;
    }

    public void setId_manufacturer(Long id) {
        this.id_manufacturer = id;
    }
    @Column(name = "manufacturer_country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    @Column(name = "manufacturer_email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "manufacturer_name")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String name) {
        this.brand = name;
    }


}
