package com.example.end.controller.dto;

public class ProductRequest {
    private String name;
    private double price;
    private String type;
    private Integer categoryId;


    public ProductRequest() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }
}