package persistencia.repositorios;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface GenericRepository<T> {

    void save(T entity);
    void delete(T entity);
    void update(T entity);
    T findById(Serializable id);
    List<T> findAll();
    void deleteById(Serializable id);
    int count();
    List<T> findByExample(T exampleObject);
    void deleteAll();

}