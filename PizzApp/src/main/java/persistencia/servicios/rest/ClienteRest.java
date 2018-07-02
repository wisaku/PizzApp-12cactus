package persistencia.servicios.rest;

import modelo.Cliente;
import persistencia.servicios.service.ClienteService;
import persistencia.servicios.dto.ClienteDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

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
        this.getClienteService().save(clienteDTOToCliente(dto));
        return Response.ok().build();
    }

    @GET
    @Path("/buscarCliente/{telefono}")
    @Produces("application/json")
    public Response buscarCliente(@PathParam("telefono")final String telefono){
        Cliente cliente = this.getClienteService().getCliente(telefono);
        if(cliente==null){
            throw new NotFoundException("el elemento buscado no existe");
        }
        return Response.ok(clienteToClienteDTO(cliente)).build();
    }

    @GET
    @Path("/todosLosClientes")
    @Produces("application/json")
    public List<ClienteDTO> todosLosCliente(){
        return listClientesToClientesDTO(this.getClienteService().todosLosClientes());
    }

    private List<ClienteDTO> listClientesToClientesDTO(List<Cliente> clientes){
        List<ClienteDTO> listDTO = new ArrayList<>();
        for(Cliente c: clientes){
            listDTO.add(clienteToClienteDTO(c));
        }
        return listDTO;
    }

    private Cliente clienteDTOToCliente(ClienteDTO dto){
        Cliente cliente = new Cliente();
        cliente.setApellido(dto.getApellido());
        cliente.setDireccion(dto.getDireccion());
        cliente.setNombre(dto.getNombre());
        cliente.setTelefono(dto.getTelefono());
        return cliente;
    }
    private ClienteDTO clienteToClienteDTO(Cliente cliente){
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setApellido(cliente.getApellido());
        clienteDTO.setDireccion(cliente.getDireccion());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setTelefono(cliente.getTelefono());
        return clienteDTO;
    }

}
