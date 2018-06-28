package modelo;

import modelo.enums.EstadoPedido;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="pedido")
public class Pedido extends Entity {

    private List<Producto> productos;
    private EstadoPedido estado= EstadoPedido.ENCURSO;
    private Cliente cliente;
    private Usuario creadoPor;

    public Pedido(){
        this.productos = new ArrayList<Producto>();

    }

    public Pedido(List<Producto> productos, Cliente cliente){
        this.productos = productos;
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {

        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public EstadoPedido getEstado(){
        return this.estado;
    }

    public boolean estaAbierto() {
        return EstadoPedido.ENCURSO.equals(getEstado());
    }


    public void setCreadoPor(Usuario usuario) {
        this.creadoPor=usuario;
    }

    public void setEstado(EstadoPedido aState){ this.estado=aState;}

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getIdCliente(){return this.cliente.getTelefono();}

    public void setIdCliente(String idCliente){this.cliente.setTelefono(idCliente);}
}
