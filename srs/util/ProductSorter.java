package util;

import model.Product;
import java.util.Comparator;
import java.util.List;

public class ProductSorter {

    public static void sortByPrice(List<Product> products) {
        products.sort(Comparator.comparingDouble(Product::getPrice));
    }
}
