import modelo.Admin;
import modelo.Producto;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductoTestCase {

    @Test
    public void creoUnProductoPizzaMozzarellaYCuandoLePreguntoSuNombreDicePizzaMozzarella(){

        Producto producto = new Producto();
        producto.setNombre("Pizza Mozzarella");

        assertEquals("Pizza Mozzarella", producto.getNombre());

    }

    @Test
    public void creoUnProductoPizzaMozzarellaDePrecio100YCuandoLePreguntoSuPrecioMeDice100(){

        Producto producto = new Producto();
        producto.setNombre("Pizza Mozzarella");
        producto.setPrecio(100);
        assertEquals(100, producto.getPrecio(),0);
    }



    @Test
    public void comoAdminQuieroDarDeAltaProductosParaAgregarALosPedidos(){

        Admin admin = new Admin();
        Producto producto = new Producto();
        assertNotNull(admin.crearProducto(producto));

    }
}
