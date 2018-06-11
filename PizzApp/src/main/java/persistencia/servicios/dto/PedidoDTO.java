package persistencia.servicios.dto;

import modelo.Entity;
import modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class PedidoDTO extends Entity {


    Integer usuario;

    private List<Producto> productos;


    public PedidoDTO(){
        this.productos = new ArrayList<Producto>();
    }
    @Override
    public void setId(int id) {
        super.setId(id);
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

}
