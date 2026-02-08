package patterns.factory;

import model.BaseEntity;

 class ProductFactory {

    public static BaseEntity create(String type, Long id, String name, double value) {
        return switch (type.toUpperCase()) {
            case "GAME" -> new GameProduct(id, name, value);
            case "APP" -> new AppProduct(id, name, value);
            default -> throw new IllegalArgumentException("Unknown product type");
        };
    }
}
