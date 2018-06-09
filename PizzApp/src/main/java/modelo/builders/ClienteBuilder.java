package modelo.builders;

import modelo.Cliente;

public class ClienteBuilder {

    private String telefono = "12345678";
    private String nombre = "Sherlock";
    private String apellido = "Holmes";
    private String direccion = "221B Baker Street";

    public static ClienteBuilder unCliente(){
        return new ClienteBuilder();
    }

    public Cliente build(){
        return new Cliente(this.telefono, this.nombre, this.apellido, this.direccion);
    }

    public ClienteBuilder conTelefono(String tel){
        this.telefono = tel;
        return this;
    }

    public ClienteBuilder conNomYApe(String nom, String ape){
        this.nombre = nom;
        this.apellido = ape;
        return this;
    }

    public ClienteBuilder conDireccion(String dire){
        this.direccion = dire;
        return this;
    }

}
