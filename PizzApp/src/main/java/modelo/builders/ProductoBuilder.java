package modelo.builders;

import modelo.Producto;
import modelo.TipoProducto;

public class ProductoBuilder {

    private String nombre;
    private double precio;
    private TipoProducto tipo;

    public static ProductoBuilder unProducto(){
        return new ProductoBuilder();
    }

    public Producto build(){
        return new Producto(this.nombre, this.precio, this.tipo);
    }

    public ProductoBuilder conNombre(String nom){
        this.nombre = nom;
        return this;
    }

    public ProductoBuilder conPrecio(double precio){
        this.precio = precio;
        return this;
    }
    public ProductoBuilder conTipo(TipoProducto tp){
        this.tipo = tp;
        return this;
    }
}
