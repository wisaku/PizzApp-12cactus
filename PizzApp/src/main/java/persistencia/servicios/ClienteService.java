package persistencia.servicios;

import modelo.Cliente;
import persistencia.repositorios.ClienteRepository;
import persistencia.servicios.dto.ClienteDTO;

public class ClienteService  extends GenericService<Cliente>{

    private ClienteRepository repository;

    @Override
    public ClienteRepository getRepository() {
        return repository;
    }

    public void setRepository(ClienteRepository repository) {
        this.repository = repository;
    }

}
