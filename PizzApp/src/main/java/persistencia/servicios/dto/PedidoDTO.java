package persistencia.servicios.dto;

import modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class PedidoDTO {


    private List<Producto> productos;

    public PedidoDTO(){
        this.productos = new ArrayList<Producto>();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
