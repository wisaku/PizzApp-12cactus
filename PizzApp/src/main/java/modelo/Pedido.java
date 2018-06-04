package modelo;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="pedido")
public class Pedido extends Entity {


    private String state = null;
    private List<Producto> productos;

    public Pedido(){
        this.init();
    }



    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    private void init() {
        this.state="Abierto";
    }

    public String getState(){
        return this.state;
    }

    public boolean estaAbierto() {
        return "Abierto".equalsIgnoreCase(getState());
    }

    public void setCreadoPor(Usuario usuario) {
        this.setCreadoPor(usuario);
    }
}
