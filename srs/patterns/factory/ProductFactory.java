public class ProductFactory {

    public static BaseEntity create(String type, Long id, String name, double value) {
        return switch (type.toUpperCase()) {
            case "DIGITAL" -> new DigitalProduct(id, name, value);
            case "PHYSICAL" -> new PhysicalProduct(id, name, value);
            default -> throw new IllegalArgumentException("Unknown product type");
        };
    }
}
