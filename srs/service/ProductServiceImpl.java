package service;

import exception.InvalidInputException;
import model.Product;
import repository.CrudRepository;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final CrudRepository<Product, Integer> repository;

    public ProductServiceImpl(CrudRepository<Product, Integer> repository) {
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
}
