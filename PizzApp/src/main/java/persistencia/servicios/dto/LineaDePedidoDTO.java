package persistencia.servicios.dto;

import modelo.Entity;

public class LineaDePedidoDTO extends Entity{

    private int idProd;
    private int cantidad;
    private String nombreProd;
    private double precio;

    public LineaDePedidoDTO(){}

    public LineaDePedidoDTO(int idProd, int cantidad, String nombreProd, double precio) {
        this.idProd = idProd;
        this.cantidad = cantidad;
        this.nombreProd = nombreProd;
        this.precio = precio;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
