package modelo;

public class LineaDePedido extends Entity{

    Pedido pedido;
    String Estado; //En curso, listo, Entregado, rechazado, anulado
    Producto producto;
    Usuario creadoPor;

    public LineaDePedido(Pedido pedido, Producto producto, Usuario usuario) {
        this.pedido = pedido;
        this.producto = producto;
        this.Estado = producto.getTipo().getInicializacion();
        this.creadoPor = usuario;
    }
}
