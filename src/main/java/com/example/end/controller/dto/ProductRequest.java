package com.example.end.controller.dto;

public class ProductRequest {
    private String name;
    private double price;
    private String type; // GAME or APP
    private Integer categoryId; // make nullable to validate missing
    private String extra; // genre for GAME, "true/false" for APP

    public ProductRequest() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }
    public String getExtra() { return extra; }
    public void setExtra(String extra) { this.extra = extra; }
}