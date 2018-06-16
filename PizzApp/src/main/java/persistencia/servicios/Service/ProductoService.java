package persistencia.servicios.Service;

import modelo.Producto;
import modelo.builders.ProductoBuilder;
import org.springframework.transaction.annotation.Transactional;
import persistencia.Initializable;
import persistencia.repositorios.ProductoRepository;

import java.util.List;

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
                ProductoBuilder.unProducto().conNombre("Empanada Pollo").conPrecio(35).build());

        this.getRepository().save(
                ProductoBuilder.unProducto().conNombre("Pizza Muzza").conPrecio(135).build());

        this.getRepository().save(
                ProductoBuilder.unProducto().conNombre("Pizza palmitos").conPrecio(250).build());


        this.getRepository().save(
                ProductoBuilder.unProducto().conNombre("Empanada Carne").conPrecio(35).build());
    }

    @Transactional
    public List<Producto> todosLosProductos() {
        return this.getRepository().findAll();
    }
}
