package modelo;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="pedido")
public class Pedido extends Entity {
    private List<Producto> productos;
    private String state="abierto"; // el estado puedo ser "cerrado" o "abierto" como state es malisimo (sirDemian)
    private int numeroDePedido=0;
    private int nroSiguientePedido=numeroDePedido+1;
    private Cliente cliente;
    private Usuario creadoPor;

    public Pedido(){
        this.productos = new ArrayList<Producto>();
        this.cliente = new Cliente();
        this.numeroDePedido=nroSiguientePedido;    ////TODO FIXME ESTO TIENE Q DESAPARECER URGENTE
        this.nroSiguientePedido=numeroDePedido+1;  ////TODO FIXME ESTO TMB
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

    public void setNumeroDePedido(int unNroPedido)    ////TODO FIXME EL PROBLEMA DE ESTO ES Q PUEDO GENERAR 2 PEDIDOS CON EL MISMO NÚMERO
    {
        this.numeroDePedido=unNroPedido;
        this.nroSiguientePedido=numeroDePedido+1;
    }

    public int getNumeroDePedido() {
        return numeroDePedido;
    }

    public int getNroSiguientePedido() {
        return nroSiguientePedido;
    }
}
