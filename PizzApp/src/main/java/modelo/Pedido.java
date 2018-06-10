package modelo;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="pedido")
public class Pedido extends Entity {

    private List<Producto> productos;
    private String state="abierto"; // el estado puedo ser "cerrado" o "abierto" como state es malisimo (sirDemian)
    private Cliente cliente;
    private Usuario creadoPor;

    public Pedido(){
        this.productos = new ArrayList<Producto>();
        this.cliente = new Cliente();

    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public String getState(){
        return this.state;
    }

    public boolean estaAbierto() {
        return "abierto".equalsIgnoreCase(getState());
    }


    public void setCreadoPor(Usuario usuario) {
        this.creadoPor=usuario;
    }

    public void setState(String aState){ this.state=aState;}

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
