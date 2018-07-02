package modelo.builders;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Producto;
import modelo.enums.EstadoPedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoBuilder {

    private Cliente cliente;
    private List<Producto> productos = new ArrayList<Producto>();
    private EstadoPedido estado;

    public static PedidoBuilder unPedido(){
        return new PedidoBuilder();
    }

    public Pedido build(){
        return new Pedido(this.cliente);
    }

    public PedidoBuilder conCliente(Cliente cliente){
        this.cliente = cliente;
        return this;
    }

    public PedidoBuilder conProducto(Producto producto){
        this.productos.add(producto);
        return this;
    }

    public PedidoBuilder conEstado(EstadoPedido estado){
        this.estado=estado;
        return this;
    }
}
