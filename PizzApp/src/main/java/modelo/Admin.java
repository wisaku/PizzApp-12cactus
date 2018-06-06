package modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Admin {

  //  private List<Pedido> pedidos=new ArrayList<Pedido>();
    private Map<Integer,Pedido> pedidos = new HashMap <Integer, Pedido>();

    public Cliente crearCliente(int telefono, String nombre, String apellido, String direccion) {
        return new Cliente(telefono,nombre,apellido,direccion);
    }

    public Producto crearProducto(Producto producto) {
        return new Producto("Pizza Fugazza",100);
    }


    public Pedido crearPedido(Integer nroPedido,Pedido pedido) {

//        this.pedidos.add(pedido);
        this.pedidos.put(nroPedido,pedido);
        return new Pedido();
    }

    public Pedido seleccionarPedido(Integer nroPedido){
        Pedido pedido = new Pedido();
        pedido=pedidos.get(nroPedido);
        return pedido;
    }
    public Pedido cerrarPedido(Integer nroPedido){

        seleccionarPedido(nroPedido).setState("cerrado");
        return seleccionarPedido(nroPedido);
    }

    public void addPedido(Integer nroPedido,Pedido unPedido)
    {
//        this.pedidos = new ArrayList<Pedido>();
        this.pedidos.put(nroPedido,unPedido);
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
