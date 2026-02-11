package com.example.end.model;

public class Game extends Product {

    public Game() {}

    public Game(Long id, String name, double price, Category category) {
        super(id, name, price, category);
    }

    @Override
    public String getType() {
        return "GAME";
    }

    @Override
    public String getDescription() {
        return "Game: " + getName();
    }
}