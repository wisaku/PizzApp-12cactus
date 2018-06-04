package modelo;

public class LineaDePedido extends Entity{

    Pedido pedido = null;
    String Estado = null; //En curso, listo, Entregado, rechazado, anulado
    Producto producto = null;
    Usuario creadoPor = null;

    public LineaDePedido(Pedido pedido, Producto producto, Usuario usuario) {
        this.pedido = pedido;
        this.producto = producto;
        this.Estado = producto.getTipo().getInicializacion();
        this.creadoPor = usuario;
    }
}
