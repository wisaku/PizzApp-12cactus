import modelo.Admin;
import modelo.Producto;
import modelo.ProductoDeElaboracion;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductoTestCase {

    @Test
    public void creoUnProductoPizzaMozzarellaYCuandoLePreguntoSuNombreDicePizzaMozzarella(){

        Producto producto = new Producto(" ", 0, new ProductoDeElaboracion());
        producto.setNombre("Pizza Mozzarella");

        assertEquals("Pizza Mozzarella", producto.getNombre());

    }

    @Test
    public void creoUnProductoPizzaMozzarellaDePrecio100YCuandoLePreguntoSuPrecioMeDice100(){

        Producto producto = new Producto(" ", 0, new ProductoDeElaboracion());
        producto.setNombre("Pizza Mozzarella");
        producto.setPrecio(100);
        assertEquals(100, producto.getPrecio(),0);
    }

    @Test
    public void creoUnProductoPizzaMozzarellaDePrecio100YCuandoLePreguntoSuPrecioMeDice100YSuNombrePizzaMozzarella(){

        Producto producto = new Producto("Pizza Mozzarella",100, new ProductoDeElaboracion());

        assertEquals(100, producto.getPrecio(),0);
        assertEquals("Pizza Mozzarella", producto.getNombre());
    }


    @Test
    public void comoAdminQuieroDarDeAltaProductosParaAgregarALosPedidos(){

        Admin admin = new Admin();
        assertNotNull(admin.crearProducto("Pizza de anana", 350.00, new ProductoDeElaboracion()));

        Producto producto = new Producto("Pizza Provolone", 120, new ProductoDeElaboracion());
      //  assertNotNull(admin.crearProducto()); ESTE TEST NO HACE LO QUE DICE
    }
}
