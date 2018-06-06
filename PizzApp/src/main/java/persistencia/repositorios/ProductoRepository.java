package persistencia.repositorios;

import modelo.Producto;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoRepository
        extends HibernateGenericDAO<Producto>
        implements GenericRepository<Producto> {
    @Override
    protected Class<Producto> getDomainClass() {
        return Producto.class;
    }
}
