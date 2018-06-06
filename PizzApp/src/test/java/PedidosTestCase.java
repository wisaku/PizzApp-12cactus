import modelo.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import persistencia.servicios.LineaDePedidoService;
import persistencia.servicios.UsuarioService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PedidosTestCase {

    @Autowired
    LineaDePedidoService lineaDePedidoService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    persistencia.servicios.PedidoService PedidoService;

    @Test
    public void comoAdminQuieroCrearUnPedidoParaCargarProductos(){

        Admin admin = new Admin();
        assertNotNull(admin.crearPedido());
    }


/*
    //TEST DE ACEPTACIÓN
    //(comoAdminQuieroSeleccionarProductosParaAgregarALosPedidosIniciados)
    @Test
    public void  agregoAUnPedido3ProductosYChequeoLaCantidadDeProductosQueTiene(){
       Admin admin = new Admin();

        Producto pizzaDeMuzzaSimple = admin.crearProducto("Pizza de muzza simple", 230.00, new ProductoDeElaboracion());
        Producto cocacolaDe600cc = admin.crearProducto("Coca cola de 600 cc", 30.00, new ProductoDeStock());
        Producto cervezaAmorir1L = admin.crearProducto("Cerveza 'Amorir' 1L", 100.00, new ProductoDeStock());

        List<Producto> productos = new ArrayList<>();

        usuarioService.save(admin);
        Pedido pedido = new Pedido();
<<<<<<< HEAD
        assertNotNull(admin.crearPedido(1,pedido));
=======
        PedidoService.crearPedido(pedido, admin.getId(), productos);


        pedido.getProductos().add(pizzaDeMuzzaSimple);
        pedido.getProductos().add(cocacolaDe600cc);
        pedido.getProductos().add(cervezaAmorir1L);

        assertTrue(lineaDePedidoService.findByPedido(pedido));
        assertTrue(pedido.estaAbierto());
>>>>>>> 66dd25635548da09058944873e322cd6eb3c1f2b
    }

    */

    @Test
    public void comoAdminQuieroCrearUnPedidoParaCargarProductosYAlPReguntarElEstadoDelPedidoRespondeAbierto(){

        Admin admin = new Admin();
        Pedido pedido = new Pedido();
<<<<<<< HEAD
        assertNotNull(admin.crearPedido(1,pedido));
=======
        assertNotNull(admin.crearPedido());
>>>>>>> 66dd25635548da09058944873e322cd6eb3c1f2b

        assertEquals("abierto",pedido.getState());
    }

    @Test
    public void comoAdminQuieroCrearUnPedidoParaCargarProductosyLuegoCerrarloYAlConsultarElEstadoDelPedidoRespondeCerrado(){

        Admin admin = new Admin();
        Pedido pedido = new Pedido();
<<<<<<< HEAD
        assertNotNull(admin.crearPedido(1,pedido));
        assertNotNull(admin.cerrarPedido(1));
=======
        assertNotNull(admin.crearPedido());
        assertNotNull(admin.cerrarPedido(pedido));
>>>>>>> 66dd25635548da09058944873e322cd6eb3c1f2b

        assertEquals("cerrado",pedido.getState());
    }

    @Test
<<<<<<< HEAD
    public void comoAdminCreoDosPedidosYCuandoLePreguntoCuantoPedidosTieneMeDiceDos(){
        Admin admin = new Admin();
        Pedido pedido = new Pedido();
        Pedido siguientePedido = new Pedido();
     //   siguientePedido.setNumeroDePedido(pedido.getNroSiguientePedido());
=======
    public void comoAdminCreoUnPedidoConElNumero10YCuandoLePreguntoSuNumeroDePedidoMeDice10(){
        Admin admin = new Admin();
        Pedido pedido = new Pedido();
        pedido.setNumeroDePedido(10);
        assertNotNull(admin.crearPedido());

        assertEquals(10,pedido.getNumeroDePedido(),0);

    }

    @Test
    public void comoAdminCreoDosPedidosElPrimeroConElNumero10YCuandoLePreguntoSuNumeroDePedidoMeDice10yElSiguiente11(){
        Admin admin = new Admin();
        Pedido pedido = new Pedido();
        Pedido siguientePedido = new Pedido();
        pedido.setNumeroDePedido(10);

        siguientePedido.setNumeroDePedido(pedido.getNroSiguientePedido());
        assertNotNull(admin.crearPedido());

        assertEquals(10,pedido.getNumeroDePedido(),0);
        assertEquals(11,siguientePedido.getNumeroDePedido(),0);

    }

    @Test
    public void comoAdminCreoDosPedidosYCuandoLePreguntoSuNumeroDePedidoMeDice1yElSiguiente2(){
        Admin admin = new Admin();
        Pedido pedido = new Pedido();
        Pedido siguientePedido = new Pedido();
        siguientePedido.setNumeroDePedido(pedido.getNroSiguientePedido());

        assertNotNull(admin.crearPedido());
>>>>>>> 66dd25635548da09058944873e322cd6eb3c1f2b

        assertNotNull(admin.crearPedido(1,pedido));
        assertNotNull(admin.crearPedido(2,siguientePedido));
        assertEquals(2,admin.getCantidadDePedidos(),0);

    }

    @Test
    public void comoAdminQuieroSeleccionarUnPedidoParaCerrarlo(){
        Admin admin = new Admin();
        Pedido pedido = new Pedido();
        Pedido siguientePedido = new Pedido();

<<<<<<< HEAD
        assertNotNull(admin.crearPedido(1,pedido));
        assertNotNull(admin.crearPedido(2,siguientePedido));
        assertEquals("abierto",pedido.getState());
        assertEquals("abierto",siguientePedido.getState());
        assertNotNull(admin.cerrarPedido(2));
        assertEquals("abierto",pedido.getState());
        assertEquals("cerrado",siguientePedido.getState());
=======
        assertNotNull(admin.crearPedido());
        assertNotNull(admin.crearPedido());
        assertEquals(2,admin.getCantidadDePedidos(),0);
>>>>>>> 66dd25635548da09058944873e322cd6eb3c1f2b

    }
}
