package persistencia.servicios.Service;

import modelo.Producto;
import persistencia.repositorios.ProductoRepository;
import persistencia.servicios.Service.GenericService;

public class ProductoService extends GenericService<Producto>
{
    private ProductoRepository repository;

    @Override
    public ProductoRepository getRepository() {
        return repository;
    }

    public void setRepository(ProductoRepository repository) {
        this.repository = repository;
    }
}
