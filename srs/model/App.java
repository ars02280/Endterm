package model;

public class App extends Product {
    private boolean paid;

    public App(int id, String name, double price, Category category, boolean paid) {
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
}
