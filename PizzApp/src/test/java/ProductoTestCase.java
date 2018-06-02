import modelo.Admin;
import modelo.Producto;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductoTestCase {

    @Test
    public void comoAdminQuieroDarDeAltaProductosParaAgregarALosPedidos(){

        Admin admin = new Admin();
        Producto producto = new Producto();
        assertNotNull(admin.crearProducto(producto));

    }
}
