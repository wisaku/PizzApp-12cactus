package persistencia.servicios;

import org.springframework.transaction.annotation.Transactional;
import persistencia.repositorios.GenericRepository;
import java.io.Serializable;
import java.util.List;

public class GenericService<T> implements Serializable {

    private GenericRepository<T> repository;

    public GenericRepository<T> getRepository() {
        return this.repository;
    }

    public void setRepository(final GenericRepository<T> repository) {
        this.repository = repository;
    }

    @Transactional
    public void delete(final T object) {
        this.getRepository().delete(object);
    }

    @Transactional(readOnly = true)
    public List<T> retriveAll() {
        return this.getRepository().findAll();
    }

    @Transactional
    public void save(final T object) {
        this.getRepository().save(object);
    }

    @Transactional
    public void update(final T object) {
        this.getRepository().update(object);
    }

    @Transactional
    public T findById(Serializable id){
        return this.getRepository().findById(id);
    }

    @Transactional
    public void deleteAll(){
        this.getRepository().deleteAll();
    }

}
