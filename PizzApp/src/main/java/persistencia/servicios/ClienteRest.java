package persistencia.servicios;

import modelo.Cliente;
import persistencia.servicios.dto.ClienteDTO;

import javax.ws.rs.*;
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
    private ClienteDTO toToDTO(Cliente cliente){
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setApellido(cliente.getApellido());
        clienteDTO.setDireccion(cliente.getDireccion());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setTelefono(cliente.getTelefono());
        return clienteDTO;
    }

    @GET
    @Path("/buscarCliente/{telefono}")
    @Produces("application/json")
    public Response buscarCliente(@PathParam("telefono")final int telefono){
        Cliente cliente =this.getClienteService().getCliente(telefono);
        return Response.ok(toToDTO(cliente)).build();
    }

}
