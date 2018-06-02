import modelo.Admin;
import modelo.Pedido;
import org.junit.Test;
import static org.junit.Assert.*;

public class PedidosTestCase {

    @Test
    public void comoAdminQuieroCrearUnPedidoParaCargarProductos(){

        Admin admin = new Admin();
        Pedido pedido = new Pedido();
        assertNotNull(admin.crearPedido(pedido));
    }
}
