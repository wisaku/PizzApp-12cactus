import modelo.Admin;
import modelo.ProductoDeElaboracion;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductoTestCase {

    @Test
    public void comoAdminQuieroDarDeAltaProductosParaAgregarALosPedidos(){

        Admin admin = new Admin();
        assertNotNull(admin.crearProducto("Pizza de anana", 350.00, new ProductoDeElaboracion()));

    }
}
