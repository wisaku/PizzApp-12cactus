package persistencia.servicios.Service;

import modelo.Cliente;
import modelo.builders.ClienteBuilder;
import org.springframework.transaction.annotation.Transactional;
import persistencia.Initializable;
import persistencia.repositorios.ClienteRepository;

public class ClienteService  extends GenericService<Cliente> implements Initializable{

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


    @Override
    @Transactional
    public void initialize() {

        this.getRepository().save(ClienteBuilder.unCliente().conNomYApe("Paula","Schab").
                conTelefono("1111").conDireccion("1111").build());

        this.getRepository().save(ClienteBuilder.unCliente().conNomYApe("Pablo","Sabaliawjfdwlaksd").
                conTelefono("2222").conDireccion("2222").build());

        this.getRepository().save(ClienteBuilder.unCliente().conNomYApe("Damian","Rigazio").
                conTelefono("3333").conDireccion("3333").build());

        this.getRepository().save(ClienteBuilder.unCliente().conNomYApe("Emanuel","Salgado").
                conTelefono("4444").conDireccion("4444").build());

        this.getRepository().save(ClienteBuilder.unCliente().conNomYApe("Maru","Gil").
                conTelefono("5555").conDireccion("5555").build());

    }
}
