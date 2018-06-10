package persistencia.servicios.dto;

import modelo.Cliente;
import modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class PedidoDTO {

    private Integer usuario;
    private List<Producto> productos;
    private Cliente cliente;

    public PedidoDTO(){
        this.productos = new ArrayList<Producto>();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
