package persistencia.servicios;

import modelo.Producto;
import persistencia.servicios.dto.ProductoDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

    private Producto fromDTO(ProductoDTO dto) {
        Producto producto = new Producto("anchoas", 300, new ProductoDeElaboracion());
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        return producto;
    }
}
