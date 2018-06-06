package modelo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

<<<<<<< HEAD
public class Admin {

  //  private List<Pedido> pedidos=new ArrayList<Pedido>();
    private Map<Integer,Pedido> pedidos = new HashMap <Integer, Pedido>();
=======
public class Admin extends Usuario{

   private List<Pedido> pedidos=new ArrayList<Pedido>();  //TODO FIXME LA LISTA DE PEDIDOS DEBRíA ESTAR EN ALGO LLAMADO PIZZERIA
>>>>>>> 66dd25635548da09058944873e322cd6eb3c1f2b

    @Override
    public Cliente crearCliente(int telefono, String nombre, String apellido, String direccion) {
        return new Cliente(telefono,nombre,apellido,direccion);
    }

    @Override
    public Producto crearProducto(String nombreProducto, Double precio, TipoProducto tipoProducto) {
        return new Producto(nombreProducto, precio, tipoProducto);
    }

<<<<<<< HEAD

    public Pedido crearPedido(Integer nroPedido,Pedido pedido) {

//        this.pedidos.add(pedido);
        this.pedidos.put(nroPedido,pedido);
        return new Pedido();
=======
    @Override
    public Pedido crearPedido() {
        Pedido nuevo = new Pedido();
        this.pedidos.add(nuevo);
        return nuevo;
>>>>>>> 66dd25635548da09058944873e322cd6eb3c1f2b
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
