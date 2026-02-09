package com.example.end.service;

import com.example.end.model.Product;
import java.util.List;

public interface ProductService {
    Product add(Product product);
    List<Product> getAll();
    Product getById(Long id);
    void update(Product product);
    void delete(Long id);
    Product getByName(String name);
}