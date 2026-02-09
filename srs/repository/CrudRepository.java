package repository;

import model.Product;

import java.util.List;

public interface CrudRepository<T, ID> {
    T create(T entity);
    T getById(ID id);
    List<T> getAll();

    Product getById(Long id);

    void update(T entity);
    void delete(ID id);
}
