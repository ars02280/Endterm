package com.example.end.model;

public class App extends Product {

    public App() {}

    public App(Long id, String name, double price, Category category) {
        super(id, name, price, category);
    }

    @Override
    public String getType() {
        return "APP";
    }

    @Override
    public String getDescription() {
        return "App: " + getName();
    }
}