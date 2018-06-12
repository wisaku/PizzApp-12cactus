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

    @GET
    @Path("/buscarCliente//{nombre}")
    @Produces("application/json")
    public Response getUno(@PathParam("nombre") final String uno){
        Cliente cliente = this.getClienteService().findById(1);       //.filterNombre("nombre");
        if(cliente==null){
            throw new NotFoundException("el cliente buscado no existe");
        }
        return Response.ok(toDTO(cliente)).build();
    }

    private ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO res = new ClienteDTO();
        res.setApellido(cliente.getApellido());
        res.setNombre(cliente.getNombre());
        res.setDireccion(cliente.getDireccion());
        res.setTelefono(cliente.getTelefono());
        return res;
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
