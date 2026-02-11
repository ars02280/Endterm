package com.example.end.service;

import com.example.end.model.Category;
import java.util.List;

public interface CategoryService {
    Category add(Category category);
    List<Category> getAll();
    Category getById(Integer id);
    void update(Category category);
    void delete(Integer id);
}
