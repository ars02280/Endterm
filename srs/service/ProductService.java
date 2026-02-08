package service;

import model.Product;
import java.util.List;

public interface ProductService {
    Product add(Product product);
    List<Product> getAll();
}
