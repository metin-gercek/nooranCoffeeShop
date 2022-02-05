package com.nooran.noorancoffeeshop.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

public class Product  extends AbstractPersistable<Long>{
    
    private String name;
    private String description;
    private Double price;
    private String image;
    private Long productsSold;

    @ManyToOne
    @JoinColumn(name = "deparment_id")
    private Deparment deparment;
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public Long getProductsSold() {
        return productsSold;
    }
    public void setProductsSold(Long productsSold) {
        this.productsSold = productsSold;
    }
    public Deparment getDeparment() {
        return deparment;
    }
    public void setDeparment(Deparment deparment) {
        this.deparment = deparment;
    }
    public Admin getAdmin() {
        return admin;
    }
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    public Manufacturer getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
    @ManyToOne    
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;
}
