package patterns.singleton;

import java.sql.Connection;

public class DatabaseConfig {
    private static DatabaseConfig instance;

    private DatabaseConfig() {}

    public static synchronized DatabaseConfig getInstance() {
        if (instance == null) {
            instance = new DatabaseConfig();
        }
        return instance;
    }

    public Connection getConnection() {
        // JDBC connection
        return null;
    }
}
