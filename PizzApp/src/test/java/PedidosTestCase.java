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
    @Test
    public void comoAdminQuieroCrearUnPedidoParaCargarProductosYAlPReguntarElEstadoDelPedidoRespondeAbierto(){

        Admin admin = new Admin();
        Pedido pedido = new Pedido();
        assertNotNull(admin.crearPedido(pedido));

        assertEquals("abierto",pedido.getState());
    }

    @Test
    public void comoAdminQuieroCrearUnPedidoParaCargarProductosyLuegoCerrarloYAlConsultarElEstadoDelPedidoRespondeCerrado(){

        Admin admin = new Admin();
        Pedido pedido = new Pedido();
        assertNotNull(admin.crearPedido(pedido));
        assertNotNull(admin.cerrarPedido(pedido));

        assertEquals("cerrado",pedido.getState());
    }

}
