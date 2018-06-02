package persistencia.repositorios;

import modelo.Pedido;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoRepository
        extends HibernateGenericDAO<Pedido>
        implements GenericRepository<Pedido> {

    @Override
    protected Class<Pedido> getDomainClass() {
        return Pedido.class;
    }
}
