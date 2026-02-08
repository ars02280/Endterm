package model;

public interface PricedItem {
    double getPrice();

    default boolean isExpensive() {
        return getPrice() > 10;
    }

    static boolean isFree(double price) {
        return price == 0;
    }
}
