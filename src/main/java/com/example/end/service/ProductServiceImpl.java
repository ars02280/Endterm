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
    private final CategoryService categoryService;

    @Autowired
    public ProductServiceImpl(CrudRepository<Product, Long> repository, CategoryService categoryService) {
        this.repository = repository;
        this.categoryService = categoryService;
    }

    @Override
    public Product add(Product product) {
        if (product.getPrice() < 0) {
            throw new InvalidInputException("Price cannot be negative");
        }
        if (product.getCategory() == null || product.getCategory().getId() == null || product.getCategory().getId() <= 0) {
            throw new InvalidInputException("Valid categoryId is required");
        }
        // проверяем что категория существует (бросит 404, если нет)
        categoryService.getById(product.getCategory().getId());
        // Проверка дубликатов по имени
        Product existing = repository.getByName(product.getName());
        if (existing != null) {
            throw new InvalidInputException("Product with name already exists: " + product.getName());
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
        if (product.getCategory() == null || product.getCategory().getId() == null || product.getCategory().getId() <= 0) {
            throw new InvalidInputException("Valid categoryId is required");
        }
        // проверяем что категория существует (бросит 404, если нет)
        categoryService.getById(product.getCategory().getId());
        // Проверка конфликта имени с другими записями
        Product sameName = repository.getByName(product.getName());
        if (sameName != null && !sameName.getId().equals(product.getId())) {
            throw new InvalidInputException("Product name is already used by another product: " + product.getName());
        }
        repository.update(product);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public Product getByName(String name) {
        return repository.getByName(name);
    }
}