package persistencia.servicios.rest;

import modelo.Producto;
import persistencia.servicios.Service.ProductoService;
import persistencia.servicios.dto.ProductoDTO;
import modelo.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/productoService")
public class ProductoRest {

    private ProductoService productoService;

    public ProductoService getProductoService() {
        return productoService;
    }

    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    @POST
    @Path("/crearProducto")
    @Produces("application/json")
    @Consumes("application/json")
    public Response crearProducto(ProductoDTO dto){
        this.getProductoService().save(fromDTO(dto));
        return Response.ok().build();
    }

    @GET
    @Path("/buscarProducto/{id}")
    @Produces("application/json")
    public Response buscarCliente(@PathParam("id")final int id){
        Producto prod = this.getProductoService().getPruducto(id);
        return Response.ok(toDTO(prod)).build();
    }

    private ProductoDTO toDTO(Producto prod) {
        ProductoDTO dto = new ProductoDTO();
        dto.setNombre(prod.getNombre());
        dto.setPrecio(prod.getPrecio());
        return dto;
    }

    private Producto fromDTO(ProductoDTO dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        return producto;
    }
}
