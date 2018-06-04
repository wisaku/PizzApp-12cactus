package modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="producto")
public class Producto extends Entity{


    private String nombre;
    private double precio;
    private TipoProducto tipo;

    public Producto(String nombre, double precio, TipoProducto tipoProducto){
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipoProducto;
    }


    public TipoProducto getTipo() {
        return tipo;
    }

}
