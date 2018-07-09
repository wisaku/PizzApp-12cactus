package com.example.saba.myapplication;

import java.io.Serializable;

class LineaDePedido implements Serializable{

    private int idProd;
    private int cantidad;
    private String nombreProd;
    private double precio;

    public LineaDePedido(){}

    public LineaDePedido(int idProd, int cantidad, String nombreProd, double precio) {
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

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

