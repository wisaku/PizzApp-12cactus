package modelo;


import java.util.ArrayList;
import java.util.List;

public class Admin {

    private List<Pedido> pedidos=new ArrayList<Pedido>();


    public Cliente crearCliente(int telefono, String nombre, String apellido, String direccion) {
        return new Cliente(telefono,nombre,apellido,direccion);
    }

    public Producto crearProducto(Producto producto) {
        return new Producto("Pizza Fugazza",100);
    }


    public Pedido crearPedido(Pedido pedido) {

        this.pedidos.add(pedido);
        return new Pedido();
    }

    public Pedido cerrarPedido(Pedido pedido){
        pedido.setState("cerrado");
        return pedido;
    }

    public void addPedido(Pedido unPedido)
    {
        this.pedidos = new ArrayList<Pedido>();
        this.pedidos.add(unPedido);
    }

    public int getCantidadDePedidos()
    {
        return this.pedidos.size();
    }
/*
    public boolean puedeHacerPedidos(int telefono) {
    }
*/
}
