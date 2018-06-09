import modelo.Admin;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClienteTestCase {

    @Test
    public void comoAdminQuieroIngresarClienteParaHacerPedidos(){

        Admin admin = new Admin();
        assertNotNull(admin.crearCliente
                ("42065201", "Daenerys", "Targaryen", "Dragonstone 136"));
        //assertTrue(admin.puedeHacerPedidos(42065201));
    }

}
