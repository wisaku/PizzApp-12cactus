package persistencia.servicios.Service;

import modelo.*;
import org.springframework.transaction.annotation.Transactional;
import persistencia.Initializable;
import persistencia.repositorios.LineaDePedidoRepository;
import persistencia.repositorios.PedidoRepository;

import java.util.List;

public class PedidoService extends GenericService<Pedido>  implements Initializable {

    private PedidoRepository repository;

    private UsuarioService usuarioService;

    private LineaDePedidoRepository lineaDePedidoRepository;

    public LineaDePedidoRepository getLineaDePedidoRepository() {
        return lineaDePedidoRepository;
    }

    public void setLineaDePedidoRepository(LineaDePedidoRepository lineaDePedidoRepository) {
        this.lineaDePedidoRepository = lineaDePedidoRepository;
    }

    @Override
    public PedidoRepository getRepository() {
        return repository;
    }

    public void setRepository(PedidoRepository repository) {
        this.repository = repository;
    }
/*
    @Transactional
    public Boolean crearPedido(Pedido pedido, Integer empleado, List<Producto> productos){
        try {
            Usuario usuario= usuarioService.findById(empleado);
            pedido.setCreadoPor(usuario);
            save(pedido);
            for(Producto producto: productos){
                LineaDePedido line = new LineaDePedido(pedido, producto, );
                lineaDePedidoService.save(line);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
*/
    @Override
    @Transactional
    public void initialize() {
        /*
        Cliente dam = ClienteBuilder.unCliente().conNomYApe("Damian","Rigazio").
                conTelefono("3333").conDireccion("3333").build();

        Cliente ema = ClienteBuilder.unCliente().conNomYApe("Emanuel","Salgado").
                conTelefono("4444").conDireccion("4444").build();

        Producto empJyQ =
                ProductoBuilder.unProducto().conNombre("Empanada JyQ").conPrecio(35).build();

        Producto pizza =
                ProductoBuilder.unProducto().conNombre("Pizza Provolone").conPrecio(135).build();


        this.getRepository().save(
                PedidoBuilder.unPedido().conCliente(dam).
                        conProducto(empJyQ).conProducto(empJyQ).
                        conProducto(empJyQ).build()
        );

        this.getRepository().save(
                PedidoBuilder.unPedido().conCliente(ema).
                        conProducto(pizza).build()
        );
    */
    }


    @Transactional
    public List<Pedido> todosLosPedidos() {
        return this.getRepository().findAll();
    }

    @Transactional
    public List<Pedido> getTodosLosPedidosPorCliente(String tel) {
        return this.getRepository().getPedidoPorIDCliente(tel);
    }

    @Transactional
    public void savePedido(Pedido pedido, List<LineaDePedido> lineaDePedidos) {
        this.getRepository().save(pedido);
        for(LineaDePedido l: lineaDePedidos){
            l.setPedido(pedido);
            this.lineaDePedidoRepository.save(l);
        }
    }

    public List<LineaDePedido> getLineaDePedido(int id) {
        return this.getLineaDePedidoRepository().findByPedido(id);
    }
}
