package model;

public abstract class Product implements PricedItem  {
    private int id;
    private String name;
    private double price;
    private Category category;

    protected Product(int id, String name, double price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // abstract methods (полиморфизм)
    public abstract String getType();
    public abstract String getDescription();

    // concrete method
    public double applyDiscount(double percent) {
        return price * (1 - percent / 100);
    }

    // encapsulation
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public Category getCategory() { return category; }
}
