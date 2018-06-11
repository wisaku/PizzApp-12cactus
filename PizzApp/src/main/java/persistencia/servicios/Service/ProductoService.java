package persistencia.servicios.Service;

import modelo.Producto;
import modelo.builders.ProductoBuilder;
import org.springframework.transaction.annotation.Transactional;
import persistencia.Initializable;
import persistencia.repositorios.ProductoRepository;

public class ProductoService extends GenericService<Producto> implements Initializable {

    private ProductoRepository repository;

    @Override
    public ProductoRepository getRepository() {
        return repository;
    }

    public void setRepository(ProductoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Producto getPruducto(int id) {
        return this.getRepository().findById(id);
    }


    @Override
    @Transactional
    public void initialize() {

        this.getRepository().save(
                ProductoBuilder.unProducto().conNombre("Empanada JyQ").conPrecio(35).build());


        this.getRepository().save(
                ProductoBuilder.unProducto().conNombre("Pizza Provolone").conPrecio(135).build());
    }
}
