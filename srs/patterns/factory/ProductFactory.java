package patterns.factory;

import model.*;


public class ProductFactory {

    public static Product create(String type, Long id, String name, double price, Category category, String genre) {
        return switch (type.toUpperCase()) {
            case "GAME" -> new Game(id, name, price, category, genre);
            case "APP" -> new App(id, name, price,category);
            default -> throw new IllegalArgumentException("Unknown product type");
        };
    }
}
