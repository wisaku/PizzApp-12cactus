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
        PedidoService.crearPedido(pedido, admin.getId(), productos);


        pedido.getProductos().add(pizzaDeMuzzaSimple);
        pedido.getProductos().add(cocacolaDe600cc);
        pedido.getProductos().add(cervezaAmorir1L);

        assertTrue(lineaDePedidoService.findByPedido(pedido));
        assertTrue(pedido.estaAbierto());

    }
    */
}
