package com.example.mobileShop.Entity;


import javax.persistence.*;

@Entity
@Table(name="manufacturers")
public class Manufacturer {

    private Long id;
    private String country;
    private String email;
    private String name;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manufacturer_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manufacturer(String country, String email, String name) {
        this.country = country;
        this.email = email;
        this.name = name;
    }

    public Manufacturer() {
    }
}
