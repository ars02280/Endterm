CREATE TABLE IF NOT EXISTS categories (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS products (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(50) UNIQUE NOT NULL,
                          price NUMERIC NOT NULL,
                          type VARCHAR(20) NOT NULL,
                          category_id INT NOT NULL,
                          FOREIGN KEY (category_id) REFERENCES categories(id)
);
