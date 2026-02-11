package com.example.end.patterns.builder;

import com.example.end.model.Category;
import com.example.end.model.Product;
import com.example.end.patterns.factory.ProductFactory;

public class ProductBuilder {
    private Long id;
    private String name;
    private String type;
    private double price;
    private Category category;

    public ProductBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public ProductBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder type(String type) {
        this.type = type;
        return this;
    }

    public ProductBuilder price(double price) {
        this.price = price;
        return this;
    }

    public ProductBuilder category(Category category) {
        this.category = category;
        return this;
    }


    public Product build() {
        return ProductFactory.create(type, id, name, price, category);
    }
}