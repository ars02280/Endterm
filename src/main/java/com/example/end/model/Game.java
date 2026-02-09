package com.example.end.model;

public class Game extends Product {
    private String genre;

    public Game() {}

    public Game(Long id, String name, double price, Category category, String genre) {
        super(id, name, price, category);
        this.genre = genre;
    }

    @Override
    public String getType() {
        return "GAME";
    }

    @Override
    public String getDescription() {
        return "Game: " + getName() + ", genre=" + genre;
    }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
}