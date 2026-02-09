package com.example.end.patterns.factory;

import com.example.end.model.*;

public class ProductFactory {
    public static Product create(String type, Long id, String name, double price, Category category, String extra) {
        if (type == null) {
            throw new IllegalArgumentException("Product type cannot be null");
        }
        return switch (type.toUpperCase()) {
            case "GAME" -> new Game(id, name, price, category, extra);
            case "APP" -> new App(id, name, price, category, Boolean.parseBoolean(extra));
            default -> throw new IllegalArgumentException("Unknown product type: " + type);
        };
    }
}