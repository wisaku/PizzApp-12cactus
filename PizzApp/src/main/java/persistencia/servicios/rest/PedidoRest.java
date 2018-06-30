package persistencia.servicios.rest;

import modelo.LineaDePedido;
import modelo.Pedido;
import modelo.Producto;
import modelo.Usuario;
import modelo.enums.EstadoPedido;
import persistencia.servicios.Service.ClienteService;
import persistencia.servicios.Service.PedidoService;
import persistencia.servicios.Service.ProductoService;
import persistencia.servicios.dto.LineaDePedidoDTO;
import persistencia.servicios.dto.PedidoDTO;
import persistencia.servicios.dto.ProductoDTO;

import javax.sound.sampled.Line;
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
        this.getPedidoService().savePedido(pedidoDTOToPedido(dto), armarLineaPedido(dto.getLinea()));
        return Response.ok().build();
    }

    private List<LineaDePedido> armarLineaPedido(List<LineaDePedidoDTO> dtos){
        List<LineaDePedido> lp = new ArrayList<>();
        for(LineaDePedidoDTO l: dtos){
            lp.add(new LineaDePedido(null,
                    this.getProductoService().findById(l.getIdProd()), l.getCantidad()));
        }
        return lp;
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
        dto.setCliente(pedido.getCliente().getTelefono());
        dto.setId(pedido.getId());
        dto.setEstado(pedido.getEstado().toString());
        List<LineaDePedido> lp = this.getPedidoService().getLineaDePedido(pedido.getId());
        List<LineaDePedidoDTO> ldto = new ArrayList<>();
        for(LineaDePedido l: lp){
            ldto.add(new LineaDePedidoDTO(l.getProducto().getId(), l.getCantidad(), l.getProducto().getNombre(),
                    l.getProducto().getPrecio()*l.getCantidad()));
        }
        dto.setLinea(ldto);
        return dto;
    }

    private Pedido pedidoDTOToPedido(PedidoDTO dto){
        Pedido pedido = new Pedido();
        pedido.setCliente(this.getClienteService().getCliente(dto.getCliente()));
        pedido.setCreadoPor(new Usuario());
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