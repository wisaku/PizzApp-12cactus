package persistencia.servicios.rest;

import modelo.Pedido;
import persistencia.servicios.Service.PedidoService;
import persistencia.servicios.dto.PedidoDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

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

        if(this.getPedidoService().crearPedido(new Pedido(), dto.getUsuario(), dto.getProductos())){
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

    private Pedido fromDTO(PedidoDTO dto){
        Pedido pedido = new Pedido();
        pedido.setProductos(dto.getProductos());
        return pedido;
    }


}
