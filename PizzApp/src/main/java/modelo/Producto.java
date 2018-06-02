package modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="producto")
public class Producto extends Entity{

    private String nombre;
    private double precio;

    public Producto(){}
}
