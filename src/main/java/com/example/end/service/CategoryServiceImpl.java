package com.example.end.service;

import com.example.end.exception.InvalidInputException;
import com.example.end.exception.ResourceNotFoundException;
import com.example.end.model.Category;
import com.example.end.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CrudRepository<Category, Integer> repository;

    @Autowired
    public CategoryServiceImpl(CrudRepository<Category, Integer> repository) {
        this.repository = repository;
    }

    @Override
    public Category add(Category category) {
        if (category.getName() == null || category.getName().isEmpty()) {
            throw new InvalidInputException("Category name cannot be empty");
        }
        Category existing = repository.getByName(category.getName());
        if (existing != null) {
            throw new InvalidInputException("Category with name already exists: " + category.getName());
        }
        return repository.create(category);
    }

    @Override
    public List<Category> getAll() {
        return repository.getAll();
    }

    @Override
    public Category getById(Integer id) {
        Category category = repository.getById(id);
        if (category == null) {
            throw new ResourceNotFoundException("Category not found with id: " + id);
        }
        return category;
    }

    @Override
    public void update(Category category) {
        if (category.getId() == null) {
            throw new InvalidInputException("Category ID is required for update");
        }
        Category sameName = repository.getByName(category.getName());
        if (sameName != null && !sameName.getId().equals(category.getId())) {
            throw new InvalidInputException("Category name already used by another category: " + category.getName());
        }
        repository.update(category);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }
}
