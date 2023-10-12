package com.example.demo.model.products;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class productDescription {
    public int id;
    public String quantity;
    public String price;
    public String brand;
    public String category;
    public String description;
    public MultipartFile file;
    public productDescription(){}
    public productDescription(String quantity, String price, String brand, String category, String description, MultipartFile photoFile) {
        this.quantity = quantity;
        this.price = price;
        this.brand = brand;
        this.category = category;
        this.description = description;
        this.file = photoFile;
    }

    public MultipartFile getPhotoFile() {
        return file;
    }

    public void setPhotoFile(MultipartFile photoFile) {
        this.file = photoFile;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
