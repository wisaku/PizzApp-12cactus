package persistencia.servicios;

import modelo.Pedido;
import persistencia.repositorios.PedidoRepository;

public class PedidoService  extends GenericService<Pedido>{

    private PedidoRepository repository;

    @Override
    public PedidoRepository getRepository() {
        return repository;
    }

    public void setRepository(PedidoRepository repository) {
        this.repository = repository;
    }
}
