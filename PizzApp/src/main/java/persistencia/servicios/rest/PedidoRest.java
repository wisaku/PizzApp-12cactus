package persistencia.servicios.rest;

import modelo.Pedido;
import modelo.Producto;
import modelo.enums.EstadoPedido;
import persistencia.servicios.Service.ClienteService;
import persistencia.servicios.Service.PedidoService;
import persistencia.servicios.Service.ProductoService;
import persistencia.servicios.dto.PedidoDTO;
import persistencia.servicios.dto.ProductoDTO;

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

    @GET
    @Path("/pedidosByCliente/{tel}")
    @Produces("application/json")
    public List<PedidoDTO> pedidosPorClienteRest(@PathParam("tel")final String tel){
        return listPedidosToPedidoDTO(this.getPedidoService().getTodosLosPedidosPorCliente(tel));
    }

    private List<PedidoDTO> listPedidosToPedidoDTO(List<Pedido> pedidos){
        List<PedidoDTO> listDTO = new ArrayList<>();
        for(Pedido p: pedidos){
            listDTO.add(pedidoDTOToPedido(p));
        }
        return listDTO;
    }


    private PedidoDTO pedidoDTOToPedido(Pedido pedido){
        PedidoDTO dto = new PedidoDTO();
        dto.setLinea(listProductoToListDtoProducto(pedido.getProductos()));
        dto.setCliente(pedido.getCliente().getTelefono());
        dto.setId(pedido.getId());
        dto.setEstado(pedido.getEstado().toString());
        return dto;
    }

    private Pedido pedidoDTOToPedido(PedidoDTO dto){
        Pedido pedido = new Pedido();
        pedido.setProductos(listDtoToListProducto(dto.getLinea()));
        pedido.setCliente(this.getClienteService().getCliente(dto.getCliente()));
        pedido.setEstado(EstadoPedido.valueOf(dto.getEstado()));
        return pedido;
    }

    private List<ProductoDTO> listProductoToListDtoProducto(List<Producto> lp){
        List<ProductoDTO> ldto = new ArrayList<>();
        for(Producto p: lp){
            ldto.add(toDTO(p));
        }
        return ldto;
    }

    private ProductoDTO toDTO(Producto prod) {
        ProductoDTO dto = new ProductoDTO();
        dto.setNombre(prod.getNombre());
        dto.setPrecio(prod.getPrecio());
        dto.setId(prod.getId());
        return dto;
    }

    private List<Producto> listDtoToListProducto(List<ProductoDTO> ldto){
        List<Producto> lp = new ArrayList<>();
        for(ProductoDTO dto: ldto){
            lp.add(fromDTO(dto));
        }
        return lp;
    }

    private Producto fromDTO(ProductoDTO dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        return producto;
    }
}