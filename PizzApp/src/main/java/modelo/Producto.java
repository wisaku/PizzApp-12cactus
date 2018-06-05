package modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="producto")
public class Producto extends Entity{

    private String nombre;
    private double precio;

    public Producto()
    {
      
    }


    public void setNombre(String unNombre)
    {
        this.nombre=unNombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPrecio(double unPrecio)
    {
        this.precio=unPrecio;
    }

    public double getPrecio() {
        return precio;
    }
}
