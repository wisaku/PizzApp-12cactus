package persistencia.servicios;

import modelo.Cliente;
import persistencia.servicios.dto.ClienteDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/clienteService")
public class ClienteRest {

    private ClienteService clienteService;

    public ClienteService getClienteService() {
        return clienteService;
    }

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @POST
    @Path("/crearCliente")
    @Produces("application/json")
    @Consumes("application/json")
    public Response crearCliente(ClienteDTO dto){
        this.getClienteService().save(fromDTO(dto));
        return Response.ok().build();
    }

    private Cliente fromDTO(ClienteDTO dto){
        Cliente cliente = new Cliente();
        cliente.setApellido(dto.getApellido());
        cliente.setDireccion(dto.getDireccion());
        cliente.setNombre(dto.getNombre());
        cliente.setTelefono(dto.getTelefono());
        return cliente;
    }
}
