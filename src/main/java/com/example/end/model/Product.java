package com.example.end.model;

public abstract class Product implements PricedItem {
    private Long id;
    private String name;
    private double price;
    private Category category;

    protected Product() {}

    protected Product(Long id, String name, double price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public abstract String getType();
    public abstract String getDescription();


    public double applyDiscount(double percent) {
        return price * (1 - percent / 100);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
}