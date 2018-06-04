package modelo;

public class ProductoDeStock implements TipoProducto{
    @Override
    public String getInicializacion() {
        return "listo para servir";
    }
}
