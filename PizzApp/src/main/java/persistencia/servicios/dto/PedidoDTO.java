package persistencia.servicios.dto;


import modelo.Entity;
import java.util.ArrayList;
import java.util.List;

public class PedidoDTO extends Entity {

    private Integer usuario;
    private List<ProductoDTO> linea;
    private String cliente;

    public PedidoDTO(){
        this.linea = new ArrayList<ProductoDTO>();
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public List<ProductoDTO> getLinea() {
        return linea;
    }

    public void setLinea(List<ProductoDTO> productos) {
        this.linea = productos;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
