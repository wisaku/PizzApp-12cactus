package persistencia.servicios.dto;


import modelo.Cliente;

import modelo.Entity;

import modelo.Producto;
import persistencia.servicios.Service.ProductoService;

import java.util.ArrayList;
import java.util.List;

public class PedidoDTO extends Entity {

    private Integer usuario;

    private List<Integer> productos;
    private Cliente cliente;
    private ProductoService productoService;


    public PedidoDTO(){
        this.productos = new ArrayList<Integer>();
    }
    @Override
    public void setId(int id) {
        super.setId(id);
    }

    public List<Producto> getProductos() {
        List<Producto> productosList=new ArrayList<Producto>();
        for(int i =0; i<productos.size();i++)
        {
           productosList.add( productoService.getPruducto(productos.get(i)));
        }
        return productosList;
    }

    public void setProductos(List<Producto> productos_p) {
        List<Integer> productosList=new ArrayList<Integer>();
        for(int i =0; i<productos_p.size();i++)
        {
            productosList.add( productos_p.get(i).getId());
        }
        this.productos = productosList;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
