package modelo;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="pedido")
public class Pedido extends Entity{

    private List<Producto> productos;
    private String state="abierto"; // el estado puedo ser "cerrado" o "abierto"
    private int numeroDePedido=0;
    private int nroSiguientePedido=numeroDePedido+1;
    private Cliente cliente;

    public Pedido(){
        this.productos = new ArrayList<Producto>();
        this.cliente = new Cliente();
        this.numeroDePedido=nroSiguientePedido;
        this.nroSiguientePedido=numeroDePedido+1;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void setState(String aState){ this.state=aState;}

    public String getState(){return this.state;}

    public void setNumeroDePedido(int unNroPedido)
    {
        this.numeroDePedido=unNroPedido;
        this.nroSiguientePedido=numeroDePedido+1;
    }

    public int getNumeroDePedido()
    {
        return numeroDePedido;
    }

    public int getNroSiguientePedido() {
        return nroSiguientePedido;
    }
}
