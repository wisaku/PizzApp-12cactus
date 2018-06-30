package persistencia.servicios.dto;


import modelo.Entity;
import java.util.ArrayList;
import java.util.List;

public class PedidoDTO extends Entity {

    private Integer usuario;
    private List<LineaDePedidoDTO> linea;
    private String cliente;
    private String estado;

    public PedidoDTO(){
        this.linea = new ArrayList<LineaDePedidoDTO>();
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public List<LineaDePedidoDTO> getLinea() {
        return linea;
    }

    public void setLinea(List<LineaDePedidoDTO> productos) {
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
