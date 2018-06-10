package modelo.builders;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class PedidoBuilder {

    private Cliente cliente;
    private List<Producto> productos = new ArrayList<Producto>();

    public static PedidoBuilder unPedido(){
        return new PedidoBuilder();
    }

    public Pedido build(){
        return new Pedido(this.productos, this.cliente);
    }

    public PedidoBuilder conCliente(Cliente cliente){
        this.cliente = cliente;
        return this;
    }

    public PedidoBuilder conProducto(Producto producto){
        this.productos.add(producto);
        return this;
    }

}
