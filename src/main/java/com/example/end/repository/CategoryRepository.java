package com.example.end.repository;

import com.example.end.model.Category;
import com.example.end.patterns.singleton.DatabaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository implements CrudRepository<Category, Integer> {

    private final DatabaseConfig databaseConfig;

    @Autowired
    public CategoryRepository(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }

    @Override
    public Category create(Category category) {
        String sql = "INSERT INTO categories(name) VALUES (?) RETURNING id";
        try (Connection conn = databaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, category.getName());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                category.setId(rs.getInt("id"));
            }
            return category;
        } catch (SQLException e) {
            throw new RuntimeException("Error creating category: " + e.getMessage(), e);
        }
    }

    @Override
    public Category getById(Integer id) {
        String sql = "SELECT id, name FROM categories WHERE id = ?";
        try (Connection conn = databaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Category(rs.getInt("id"), rs.getString("name"));
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Error getting category by id: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT id, name FROM categories";
        try (Connection conn = databaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                categories.add(new Category(rs.getInt("id"), rs.getString("name")));
            }
            return categories;
        } catch (SQLException e) {
            throw new RuntimeException("Error getting all categories: " + e.getMessage(), e);
        }
    }

    @Override
    public void update(Category category) {
        String sql = "UPDATE categories SET name = ? WHERE id = ?";
        try (Connection conn = databaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, category.getName());
            stmt.setInt(2, category.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating category: " + e.getMessage(), e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM categories WHERE id = ?";
        try (Connection conn = databaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting category: " + e.getMessage(), e);
        }
    }

    @Override
    public Category getByName(String name) {
        String sql = "SELECT id, name FROM categories WHERE name = ?";
        try (Connection conn = databaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Category(rs.getInt("id"), rs.getString("name"));
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Error getting category by name: " + e.getMessage(), e);
        }
    }
}
