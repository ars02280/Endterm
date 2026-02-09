package com.example.end.model;

public class App extends Product {
    private boolean paid;

    public App() {}

    public App(Long id, String name, double price, Category category, boolean paid) {
        super(id, name, price, category);
        this.paid = paid;
    }

    @Override
    public String getType() {
        return "APP";
    }

    @Override
    public String getDescription() {
        return "App: " + getName() + ", paid=" + paid;
    }

    @Override
    public String getExtra() {
        return String.valueOf(paid);
    }

    public boolean isPaid() { return paid; }
    public void setPaid(boolean paid) { this.paid = paid; }
}