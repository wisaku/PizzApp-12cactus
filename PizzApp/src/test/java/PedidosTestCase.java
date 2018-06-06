import modelo.Admin;
import modelo.Pedido;
import org.junit.Test;
import static org.junit.Assert.*;

public class PedidosTestCase {

    @Test
    public void comoAdminQuieroCrearUnPedidoParaCargarProductos(){

        Admin admin = new Admin();
        Pedido pedido = new Pedido();
        assertNotNull(admin.crearPedido(1,pedido));
    }
    @Test
    public void comoAdminQuieroCrearUnPedidoParaCargarProductosYAlPReguntarElEstadoDelPedidoRespondeAbierto(){

        Admin admin = new Admin();
        Pedido pedido = new Pedido();
        assertNotNull(admin.crearPedido(1,pedido));

        assertEquals("abierto",pedido.getState());
    }

    @Test
    public void comoAdminQuieroCrearUnPedidoParaCargarProductosyLuegoCerrarloYAlConsultarElEstadoDelPedidoRespondeCerrado(){

        Admin admin = new Admin();
        Pedido pedido = new Pedido();
        assertNotNull(admin.crearPedido(1,pedido));
        assertNotNull(admin.cerrarPedido(1));

        assertEquals("cerrado",pedido.getState());
    }

    @Test
    public void comoAdminCreoDosPedidosYCuandoLePreguntoCuantoPedidosTieneMeDiceDos(){
        Admin admin = new Admin();
        Pedido pedido = new Pedido();
        Pedido siguientePedido = new Pedido();
     //   siguientePedido.setNumeroDePedido(pedido.getNroSiguientePedido());

        assertNotNull(admin.crearPedido(1,pedido));
        assertNotNull(admin.crearPedido(2,siguientePedido));
        assertEquals(2,admin.getCantidadDePedidos(),0);

    }

    @Test
    public void comoAdminQuieroSeleccionarUnPedidoParaCerrarlo(){
        Admin admin = new Admin();
        Pedido pedido = new Pedido();
        Pedido siguientePedido = new Pedido();

        assertNotNull(admin.crearPedido(1,pedido));
        assertNotNull(admin.crearPedido(2,siguientePedido));
        assertEquals("abierto",pedido.getState());
        assertEquals("abierto",siguientePedido.getState());
        assertNotNull(admin.cerrarPedido(2));
        assertEquals("abierto",pedido.getState());
        assertEquals("cerrado",siguientePedido.getState());

    }
}
