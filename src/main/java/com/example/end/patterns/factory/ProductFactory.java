package com.example.end.patterns.factory;

import com.example.end.model.*;

public class ProductFactory {
    public static Product create(String type, Long id, String name, double price, Category category) {
        if (type == null) {
            throw new IllegalArgumentException("Product type cannot be null");
        }
        return switch (type.toUpperCase()) {
            case "GAME" -> new Game(id, name, price, category);
            case "APP" -> new App(id, name, price, category);
            default -> throw new IllegalArgumentException("Unknown product type: " + type);
        };
    }
}