package persistencia.servicios.Service;

import modelo.Cliente;
import org.springframework.transaction.annotation.Transactional;
import persistencia.repositorios.ClienteRepository;

public class ClienteService  extends GenericService<Cliente> {

    private ClienteRepository repository;

    @Override
    public ClienteRepository getRepository() {
        return repository;
    }

    public void setRepository(ClienteRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Cliente getCliente(String telefono)
    {
        return this.getRepository().getClienteByPhone(telefono);
    }

    @Transactional
    public int getSize() {
        return this.getRepository().count();
    }
}
