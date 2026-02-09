package repository;

import config.DatabaseConnection;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class ProductRepository implements CrudRepository<Product, Integer> {

        @Override
        public Product create(Product product) {
            String sql = """
                INSERT INTO products(name, price, type, category_id)
                VALUES (?, ?, ?, ?) RETURNING id
            """;

            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, product.getName());
                stmt.setDouble(2, product.getPrice());
                stmt.setString(3, product.getType());
                stmt.setInt(4, product.getCategory().getId());

                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                int a = rs.getInt("id");
                long b = a;
                product.setId(b);
            }
            return product;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        @Override
        public Product getById(Integer integer) {
            return null;
        }

        @Override
    public List<Product> getAll() {
        String sql = """
            SELECT p.id, p.name, p.price, p.type,
                   c.id AS cat_id, c.name AS cat_name
            FROM products p
            JOIN categories c ON p.category_id = c.id
        """;

        List<Product> list = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Category cat = new Category(
                        rs.getInt("cat_id"),
                        rs.getString("cat_name")
                );

                Product p;
                if ("GAME".equals(rs.getString("type"))) {
                    p = new Game(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getDouble("price"),
                            cat,
                            "Unknown"
                    );
                } else {
                    p = new App(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getDouble("price"),
                            cat


                    );
                }
                list.add(p);
            }
            return list;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product getById(Long id) {
        return getAll().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Product product) {
        String sql = """
            UPDATE products
            SET name = ?, price = ?, category_id = ?
            WHERE id = ?
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getCategory().getId());
            stmt.setLong(4, product.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM products WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
