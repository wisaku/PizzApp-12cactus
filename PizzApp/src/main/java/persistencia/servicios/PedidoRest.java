package persistencia.servicios;

import modelo.Pedido;
import persistencia.servicios.dto.PedidoDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/pedidoService")
public class PedidoRest {

    private PedidoService pedidoService;

    public PedidoService getPedidoService() {
        return pedidoService;
    }

    public void setPedidoService(PedidoService pedidoService) {
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

    private Pedido fromDTO(PedidoDTO dto){
        Pedido pedido = new Pedido();
        pedido.setProductos(dto.getProductos());
        return pedido;
    }
}
