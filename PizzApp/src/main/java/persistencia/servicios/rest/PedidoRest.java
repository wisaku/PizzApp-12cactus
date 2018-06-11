package persistencia.servicios.rest;

import modelo.Pedido;
import persistencia.servicios.Service.PedidoService;
import persistencia.servicios.dto.PedidoDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/pedidoService")
public class PedidoRest {

    private PedidoService pedidoService;

    public PedidoService getPedidoService() {
        return pedidoService;
    }

    public void setPedidoService(PedidoService pedidoService)    {
        this.pedidoService = pedidoService;
    }

    @POST
    @Path("/crearPedido")
    @Produces("application/json")
    @Consumes("application/json")
    public Response crearPedido(PedidoDTO dto){
        this.getPedidoService().save(fromDTO(dto));
        return Response.ok().build();
    }

    @GET
    @Path("/buscarPedido/{idCliente}")
    @Produces("application/json")
    public List<PedidoDTO> buscarPedido(@PathParam("idCliente")final String idCliente){
        return toDTO(this.getPedidoService().getPedido(idCliente));

    }




    private Pedido fromDTO(PedidoDTO dto){
        Pedido pedido = new Pedido();
        pedido.setProductos(dto.getProductos());
        pedido.setCliente(dto.getCliente());
        return pedido;
    }

    private List<PedidoDTO> toDTO(List<Pedido> pedidos){
        List<PedidoDTO> pedidosDTO = new ArrayList<PedidoDTO>();
        for(Pedido p: pedidos) {
            PedidoDTO pedidoDTO = new PedidoDTO();
            pedidoDTO.setProductos(p.getProductos());
            pedidoDTO.setCliente(p.getCliente());
            pedidosDTO.add(pedidoDTO);
        }
        return pedidosDTO;

    }

}
