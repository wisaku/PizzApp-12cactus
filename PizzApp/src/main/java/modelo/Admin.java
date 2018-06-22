package modelo;
import java.util.HashMap;
import java.util.Map;

public class Admin extends Usuario{

  //  private List<Pedido> pedidos=new ArrayList<Pedido>();
    private Map<Integer,Pedido> pedidos = new HashMap <Integer, Pedido>(); //TODO FIXME LA LISTA DE PEDIDOS DEBRíA ESTAR EN ALGO LLAMADO PIZZERIA





    @Override
    public Cliente crearCliente(String telefono, String nombre, String apellido, String direccion) {
        return new Cliente(telefono,nombre,apellido,direccion);
    }

    @Override
    public Producto crearProducto(String nombreProducto, Double precio, TipoProducto tipoProducto) {
        return new Producto(nombreProducto, precio, tipoProducto);
    }


    public Pedido crearPedido(Integer nropedido) {
        Pedido pedido = new Pedido();
        this.pedidos.put(pedido.getId(),pedido);
        return pedido;

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
