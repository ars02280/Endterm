package com.example.end.patterns.singleton;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DatabaseConfig {
    private static DatabaseConfig instance;

    @Value("${spring.datasource.url:jdbc:postgresql://localhost:5432/postgres}")
    private String url;

    @Value("${spring.datasource.username:postgres}")
    private String username;

    @Value("${spring.datasource.password:87654321}")
    private String password;

    private DatabaseConfig() {}

    // Singleton pattern (lazy initialization)
    // Note: In Spring, we usually let Spring manage the singleton.
    // But to satisfy the "Design Pattern" requirement explicitly:
    public static synchronized DatabaseConfig getInstance() {
        if (instance == null) {
            instance = new DatabaseConfig();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}