package com.example.saba.myapplication;

import com.android.volley.ServerError;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Serializable {

    private Integer id;
    private Integer usuario;
    private List<LineaDePedido> linea;
    private String cliente;
    private String estado;

    public Pedido(){
        this.linea = new ArrayList<LineaDePedido>();
        this.cliente = "0";
        this.usuario = 1;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public List<LineaDePedido> getLinea() {
        return linea;
    }

    public void setLinea(List<LineaDePedido> productos) {
        this.linea = productos;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}


