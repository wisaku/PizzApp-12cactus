package modelo;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="pedido")
public class Pedido extends Entity{

    private List<Producto> productos;

    public Pedido(){
        this.productos = new ArrayList<Producto>();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
