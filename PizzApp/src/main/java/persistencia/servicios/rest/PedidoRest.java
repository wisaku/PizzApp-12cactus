package persistencia.servicios.rest;

import modelo.Pedido;
import modelo.Usuario;
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

        this.getPedidoService().save(fromDTO(dto));
        return Response.ok().build();
    }

/*        if(this.getPedidoService().crearPedido(new Pedido(), dto.getUsuario(), dto.getProductos())){
            return Response.ok().build();
        }
        return Response.serverError().build();
    }
*/

    @GET
    @Path("/buscarPedido/{idCliente}")
    @Produces("application/json")
    public Response buscarPedido(@PathParam("idCliente")final String idCliente){
        Pedido pedido = this.getPedidoService().getPedido(idCliente);
        if(pedido==null){
            throw new NotFoundException("el elemento buscado no existe");
        }
        return Response.ok(toDTO(pedido)).build();
    }


    private Pedido fromDTO(PedidoDTO dto){
        Pedido pedido = new Pedido();
        Usuario usuario = new Usuario();
        pedido.setCreadoPor(usuario);
        pedido.setProductos(dto.getProductos());
        return pedido;
    }

    private PedidoDTO toDTO(Pedido pedido){
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setId(pedido.getId());


        return pedidoDTO;
    }

}
