package persistencia.servicios.dto;

import modelo.Entity;

public class ProductoDTO extends Entity{

    private String nombre;
    private double precio;
    private Integer cantidad;

    public ProductoDTO(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}
