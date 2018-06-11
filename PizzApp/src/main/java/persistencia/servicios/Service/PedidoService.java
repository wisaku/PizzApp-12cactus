package persistencia.servicios.Service;

import modelo.*;
import org.springframework.transaction.annotation.Transactional;
import persistencia.repositorios.PedidoRepository;

import java.util.List;

public class PedidoService extends GenericService<Pedido> {

    private PedidoRepository repository;

    private UsuarioService usuarioService;

    private LineaDePedidoService lineaDePedidoService;

    @Override
    public PedidoRepository getRepository() {
        return repository;
    }

    public void setRepository(PedidoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Boolean crearPedido(Pedido pedido, Integer empleado, List<Producto> productos){
        try {
            Usuario usuario= usuarioService.findById(empleado);
            pedido.setCreadoPor(usuario);
            save(pedido);
            for(Producto producto: productos){
                LineaDePedido line = new LineaDePedido(pedido, producto, usuario);
                lineaDePedidoService.save(line);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }


    @Transactional
    public List<Pedido> getPedido( String idCliente)
    {
        return this.getRepository().getPedidoPorIDCliente(idCliente);
    }


}
