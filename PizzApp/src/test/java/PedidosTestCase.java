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

    @Test
    public void comoAdminCreoUnPedidoConElNumero10YCuandoLePreguntoSuNumeroDePedidoMeDice10(){
        Admin admin = new Admin();
        Pedido pedido = new Pedido();
        pedido.setNumeroDePedido(10);
        assertNotNull(admin.crearPedido(pedido));

        assertEquals(10,pedido.getNumeroDePedido(),0);

    }

    @Test
    public void comoAdminCreoDosPedidosElPrimeroConElNumero10YCuandoLePreguntoSuNumeroDePedidoMeDice10yElSiguiente11(){
        Admin admin = new Admin();
        Pedido pedido = new Pedido();
        Pedido siguientePedido = new Pedido();
        pedido.setNumeroDePedido(10);

        siguientePedido.setNumeroDePedido(pedido.getNroSiguientePedido());
        assertNotNull(admin.crearPedido(pedido));

        assertEquals(10,pedido.getNumeroDePedido(),0);
        assertEquals(11,siguientePedido.getNumeroDePedido(),0);

    }

    @Test
    public void comoAdminCreoDosPedidosYCuandoLePreguntoSuNumeroDePedidoMeDice1yElSiguiente2(){
        Admin admin = new Admin();
        Pedido pedido = new Pedido();
        Pedido siguientePedido = new Pedido();
        siguientePedido.setNumeroDePedido(pedido.getNroSiguientePedido());

        assertNotNull(admin.crearPedido(pedido));

        assertEquals(1,pedido.getNumeroDePedido(),0);
        assertEquals(2,siguientePedido.getNumeroDePedido(),0);

    }

    @Test
    public void comoAdminCreoDosPedidosYCuandoLePreguntoCuantoPedidosTieneMeDiceDos(){
        Admin admin = new Admin();
        Pedido pedido = new Pedido();
        Pedido siguientePedido = new Pedido();
        siguientePedido.setNumeroDePedido(pedido.getNroSiguientePedido());

        assertNotNull(admin.crearPedido(pedido));
        assertNotNull(admin.crearPedido(siguientePedido));
        assertEquals(2,admin.getCantidadDePedidos(),0);

    }

}
