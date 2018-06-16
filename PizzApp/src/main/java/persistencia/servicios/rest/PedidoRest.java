package persistencia.servicios.rest;

import modelo.Pedido;
import persistencia.servicios.Service.ClienteService;
import persistencia.servicios.Service.PedidoService;
import persistencia.servicios.Service.ProductoService;
import persistencia.servicios.dto.PedidoDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/pedidoService")
public class PedidoRest {

    private PedidoService pedidoService;

    private ClienteService clienteService;

    private ProductoService productoService;

    public PedidoService getPedidoService() {
        return pedidoService;
    }

    public void setPedidoService(PedidoService pedidoService)    {
        this.pedidoService = pedidoService;
    }

    public ClienteService getClienteService() {
        return clienteService;
    }

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public ProductoService getProductoService() {
        return productoService;
    }

    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    @POST
    @Path("/crearPedido")
    @Produces("application/json")
    @Consumes("application/json")
    public Response crearPedido(PedidoDTO dto){
        this.getPedidoService().save(pedidoDTOToPedido(dto));
        return Response.ok().build();
    }

    @GET
    @Path("/todosLosPedidos")
    @Produces("application/json")
    public List<PedidoDTO> todosLosPedidos(){
        return listPedidosToPedidoDTO(this.getPedidoService().todosLosPedidos());
    }

    private List<PedidoDTO> listPedidosToPedidoDTO(List<Pedido> clientes){
        List<PedidoDTO> listDTO = new ArrayList<>();
        for(Pedido c: clientes){
            listDTO.add(pedidoDTOToPedido(c));
        }
        return listDTO;
    }

    private PedidoDTO pedidoDTOToPedido(Pedido pedido){
        PedidoDTO dto = new PedidoDTO();
        dto.setProductos(pedido.getProductos());
        dto.setCliente(pedido.getCliente());
        return dto;
    }

    private Pedido pedidoDTOToPedido(PedidoDTO dto){
        Pedido pedido = new Pedido();
        pedido.setProductos(dto.getProductos());
        pedido.setCliente(dto.getCliente());
        return pedido;
    }


}