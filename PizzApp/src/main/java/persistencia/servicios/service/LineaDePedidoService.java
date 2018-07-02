package persistencia.servicios.service;

import modelo.LineaDePedido;
import persistencia.repositorios.LineaDePedidoRepository;

import java.util.List;

public class LineaDePedidoService extends GenericService<LineaDePedido> {

    private LineaDePedidoRepository repository;

    @Override
    public LineaDePedidoRepository getRepository() {
        return repository;
    }

    public void setRepository(LineaDePedidoRepository repository) {
        this.repository = repository;
    }

    List<LineaDePedido> findByPedido(int pedido){
        return getRepository().findByPedido(pedido);
    }
}
