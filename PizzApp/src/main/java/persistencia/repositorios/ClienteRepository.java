package persistencia.repositorios;

import modelo.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository
        extends HibernateGenericDAO<Cliente>
        implements GenericRepository<Cliente> {
    @Override
    protected Class<Cliente> getDomainClass() {
        return Cliente.class;
    }
}
