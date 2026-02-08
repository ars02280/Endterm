package interfaces;


import java.util.List;

public interface CrudRepository<T, ID> {
    void create(T entity) throws exception.DatabaseOperationException;
    T getById(ID id) throws exception.ResourceNotFoundException;
    List<T> getAll() throws exception.DatabaseOperationException;
    void update(ID id, T entity);
    void delete(ID id);
}

