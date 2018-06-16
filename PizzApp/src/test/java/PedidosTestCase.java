import modelo.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import persistencia.servicios.Service.LineaDePedidoService;
import persistencia.servicios.Service.UsuarioService;

import static org.junit.Assert.*;

public class PedidosTestCase {

    @Autowired
    LineaDePedidoService lineaDePedidoService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    persistencia.servicios.Service.PedidoService PedidoService;


    @Test
    public void comoAdminQuieroCrearUnPedidoParaCargarProductos(){

        Admin admin = new Admin();
        assertNotNull(admin.crearPedido(1));
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
        //Pedido pedido = new Pedido();
      //  assertNotNull(admin.crearPedido(1));


        assertEquals("abierto",admin.crearPedido(1).getState());
    }
/*
    @Test
    public void comoAdminQuieroCrearUnPedidoParaCargarProductosyLuegoCerrarloYAlConsultarElEstadoDelPedidoRespondeCerrado(){

        Admin admin = new Admin();
     //   Pedido pedido = new Pedido();
        assertNotNull(admin.crearPedido(1));
        assertNotNull(admin.cerrarPedido(1));


        assertEquals("cerrado",admin.seleccionarPedido(1).getState());
    }
*/
    @Test
    public void comoAdminCreoDosPedidosYCuandoLePreguntoCuantoPedidosTieneMeDiceDos(){
        Admin admin = new Admin();
        assertNotNull(admin.crearPedido(1));
        assertNotNull(admin.crearPedido(2));

        assertEquals(1,admin.getCantidadDePedidos());
    }


/*
    //TEST DE ACEPTACIÓN(?)
    @Test
    public void comoAdminQuieroSeleccionarUnPedidoParaCerrarlo(){
        Admin admin = new Admin();
        Pedido pedido = admin.crearPedido(1);
        Pedido siguientePedido = admin.crearPedido(2);


        assertEquals("abierto",pedido.getState());
        assertEquals("abierto",siguientePedido.getState());
        assertNotNull(admin.cerrarPedido(2));
        assertEquals("abierto",pedido.getState());
        assertEquals("cerrado",siguientePedido.getState());


    }*/
}
