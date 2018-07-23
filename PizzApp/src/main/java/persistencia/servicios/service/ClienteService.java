package persistencia.servicios.service;

import modelo.Cliente;
import modelo.builders.ClienteBuilder;
import org.springframework.transaction.annotation.Transactional;
import persistencia.Initializable;
import persistencia.repositorios.ClienteRepository;

import java.util.List;

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

        this.getRepository().save(ClienteBuilder.unCliente().conNomYApe("Mesa-1","Salon").
                conTelefono("212").conDireccion("212").build());

        this.getRepository().save(ClienteBuilder.unCliente().conNomYApe("Mesa-2","Salon").
                conTelefono("213").conDireccion("213").build());

        this.getRepository().save(ClienteBuilder.unCliente().conNomYApe("Mesa-3","Salon").
                conTelefono("214").conDireccion("214").build());

        this.getRepository().save(ClienteBuilder.unCliente().conNomYApe("Mesa-4","Salon").
                conTelefono("215").conDireccion("215").build());

        this.getRepository().save(ClienteBuilder.unCliente().conNomYApe("Mesa-5","Salon").
                conTelefono("216").conDireccion("216").build());

        this.getRepository().save(ClienteBuilder.unCliente().conNomYApe("Mesa-6","Salon").
                conTelefono("217").conDireccion("217").build());

        this.getRepository().save(ClienteBuilder.unCliente().conNomYApe("Mesa-7","Salon").
                conTelefono("218").conDireccion("218").build());

        this.getRepository().save(ClienteBuilder.unCliente().conNomYApe("Mesa-8","Salon").
                conTelefono("219").conDireccion("219").build());

        this.getRepository().save(ClienteBuilder.unCliente().conNomYApe("Mesa-9","Salon").
                conTelefono("220").conDireccion("220").build());

        this.getRepository().save(ClienteBuilder.unCliente().conNomYApe("Mesa-10","Salon").
                conTelefono("221").conDireccion("221").build());

    }

    @Transactional
    public List<Cliente> todosLosClientes() {
        return this.getRepository().findAll();
    }
}
