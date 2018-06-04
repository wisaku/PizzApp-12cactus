package modelo;


public class Admin extends Usuario{

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
        return new Pedido();
    }

/*
    public boolean puedeHacerPedidos(int telefono) {
    }
*/
}
