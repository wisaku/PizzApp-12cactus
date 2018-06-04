package persistencia.servicios;

import modelo.LineaDePedido;
import modelo.Pedido;
import persistencia.repositorios.LineaDePedidoRepository;
import persistencia.repositorios.PedidoRepository;

import java.util.List;

public class LineaDePedidoService extends GenericService<LineaDePedido>{

    private LineaDePedidoRepository repository;

    @Override
    public LineaDePedidoRepository getRepository() {
        return repository;
    }

    public void setRepository(LineaDePedidoRepository repository) {
        this.repository = repository;
    }

    List<LineaDePedido> findByPedido(Pedido pedido){
        return getRepository().findByPedido(pedido);
    }
}
