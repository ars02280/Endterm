package com.example.end.service;

import com.example.end.exception.InvalidInputException;
import com.example.end.exception.ResourceNotFoundException;
import com.example.end.model.Product;
import com.example.end.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final CrudRepository<Product, Long> repository;

    @Autowired
    public ProductServiceImpl(CrudRepository<Product, Long> repository) {
        this.repository = repository;
    }

    @Override
    public Product add(Product product) {
        if (product.getPrice() < 0) {
            throw new InvalidInputException("Price cannot be negative");
        }
        return repository.create(product);
    }

    @Override
    public List<Product> getAll() {
        return repository.getAll();
    }

    @Override
    public Product getById(Long id) {
        Product p = repository.getById(id);
        if (p == null) throw new ResourceNotFoundException("Product not found: " + id);
        return p;
    }

    @Override
    public void update(Product product) {
        if (product.getId() == null) throw new InvalidInputException("ID is required for update");
        repository.update(product);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}