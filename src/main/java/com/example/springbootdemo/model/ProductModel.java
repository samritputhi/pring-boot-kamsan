package com.example.springbootdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ProductModel {
    @Id
    @GeneratedValue

    private Long id;

    private String name;

    private String description;

    private String imageUrl;

    private double price;


    // encapsulation

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public ProductModel() {

    }


    public ProductModel(String name,String description,String imageUrl,double price){
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
    }

}
