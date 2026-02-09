package com.example.end.repository;

import com.example.end.model.*;
import com.example.end.patterns.factory.ProductFactory;
import com.example.end.patterns.singleton.DatabaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements CrudRepository<Product, Long> {

    private final DatabaseConfig databaseConfig;

    @Autowired
    public ProductRepository(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }

    @Override
    public Product create(Product product) {
        String sql = "INSERT INTO products(name, price, type, category_id) VALUES (?, ?, ?, ?) RETURNING id";
        try (Connection conn = databaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setString(3, product.getType());
            stmt.setInt(4, product.getCategory().getId());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                product.setId(rs.getLong("id"));
            }
            return product;
        } catch (SQLException e) {
            throw new RuntimeException("Error creating product: " + e.getMessage(), e);
        }
    }

    @Override
    public Product getById(Long id) {
        String sql = "SELECT p.id, p.name, p.price, p.type, p.category_id, c.name as category_name FROM products p JOIN categories c ON p.category_id = c.id WHERE p.id = ?";
        try (Connection conn = databaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToProduct(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Error getting product by id: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT p.id, p.name, p.price, p.type, p.category_id, c.name as category_name FROM products p JOIN categories c ON p.category_id = c.id";
        try (Connection conn = databaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                products.add(mapResultSetToProduct(rs));
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException("Error getting all products: " + e.getMessage(), e);
        }
    }

    @Override
    public void update(Product product) {
        String sql = "UPDATE products SET name = ?, price = ?, type = ?, category_id = ? WHERE id = ?";
        try (Connection conn = databaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setString(3, product.getType());
            stmt.setInt(4, product.getCategory().getId());
            stmt.setLong(5, product.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating product: " + e.getMessage(), e);
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM products WHERE id = ?";
        try (Connection conn = databaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting product: " + e.getMessage(), e);
        }
    }

    private Product mapResultSetToProduct(ResultSet rs) throws SQLException {
        Category category = new Category(rs.getInt("category_id"), rs.getString("category_name"));
        // 'extra' столбца нет в схеме, поэтому передаем null: для APP это будет false, для GAME жанр null
        return ProductFactory.create(
                rs.getString("type"),
                rs.getLong("id"),
                rs.getString("name"),
                rs.getDouble("price"),
                category,
                null
        );
    }
}