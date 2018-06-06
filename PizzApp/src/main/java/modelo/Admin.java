package modelo;
import java.util.ArrayList;
import java.util.List;

public class Admin extends Usuario{
      private List<Pedido> pedidos=new ArrayList<Pedido>();  //TODO FIXME LA LISTA DE PEDIDOS DEBRíA ESTAR EN ALGO LLAMADO PIZZERIA

    @Override
    public Cliente crearCliente(int telefono, String nombre, String apellido, String direccion) {
        return new Cliente(telefono,nombre,apellido,direccion);
    }

    @Override
    public Producto crearProducto(String nombreProducto, Double precio, TipoProducto tipoProducto) {
        return new Producto(nombreProducto, precio, tipoProducto);
    }

    @Override
    public Pedido crearPedido() {
      Pedido nuevo = new Pedido();
      this.pedidos.add(nuevo);
      return nuevo;
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
