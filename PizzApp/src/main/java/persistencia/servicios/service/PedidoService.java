package persistencia.servicios.service;

import modelo.*;
import modelo.enums.EstadoPedido;
import org.springframework.transaction.annotation.Transactional;
import persistencia.Initializable;
import persistencia.repositorios.LineaDePedidoRepository;
import persistencia.repositorios.PedidoRepository;
import scala.tools.nsc.backend.jvm.analysis.Null;

import java.util.ArrayList;
import java.util.Iterator;
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
        if (new Integer(pedido.getId()) == null || pedido.getId() == 0){
            this.getRepository().save(pedido);
            this.agregarLineas(lineaDePedidos,pedido);
        }else{
            this.getRepository().update(pedido);
            updateLineas(lineaDePedidos, pedido);
        }
    }

    @Transactional
    private void agregarLineas(List<LineaDePedido> lineaDePedidos, Pedido pedido) {
        for(LineaDePedido l: lineaDePedidos){
            l.setPedido(pedido);
            this.lineaDePedidoRepository.save(l);
        }
    }

    @Transactional
    private void updateLineas(List<LineaDePedido> lineaDePedidosNuevo , Pedido pedido) {
        List<LineaDePedido> lineaDelPedidoViejo = lineaDePedidoRepository.findByPedido(pedido.getId());
        List lineasAAgregar = new ArrayList<LineaDePedido>();
        //voy a agregar los que estan en el nuevo pedido y no en el viejo
        for(LineaDePedido lin : lineaDePedidosNuevo){
            Boolean existeYa = false;
            for(LineaDePedido li :lineaDelPedidoViejo ){
                if(li.getProducto().getNombre().equalsIgnoreCase(lin.getProducto().getNombre())){
                    existeYa = true;
                }
            }
            if(!existeYa){
                lineasAAgregar.add(lin);
            }
        }
        Iterator iterator = lineaDelPedidoViejo.iterator();
        while(iterator.hasNext()){
            Boolean estaViejaEnLaNueva = false;
            LineaDePedido aBorrar = (LineaDePedido) iterator.next();
            for(LineaDePedido lin : lineaDePedidosNuevo) {

                if (aBorrar.getProducto().getNombre().equalsIgnoreCase(lin.getProducto().getNombre())) {
                    aBorrar.setCantidad(lin.getCantidad());
                    this.lineaDePedidoRepository.update(aBorrar);
                    estaViejaEnLaNueva = true;
                }
            }
            if(!estaViejaEnLaNueva)
                this.lineaDePedidoRepository.delete(aBorrar);

        }

        agregarLineas(lineasAAgregar,pedido);
    }

    public List<LineaDePedido> getLineaDePedido(int id) {
        return this.getLineaDePedidoRepository().findByPedido(id);
    }

    @Transactional
    public void cancelarPedido(Integer id) {
        Pedido pedidoModificado = this.getRepository().findById(id);
        pedidoModificado.setEstado(EstadoPedido.RECHAZADO);
        this.getRepository().save(pedidoModificado);
    }
}
