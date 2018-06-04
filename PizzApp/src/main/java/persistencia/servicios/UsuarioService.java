package persistencia.servicios;

import modelo.Usuario;
import persistencia.repositorios.UsuarioRepository;

public class UsuarioService extends GenericService<Usuario>{

    private UsuarioRepository repository;



    @Override
    public UsuarioRepository getRepository() {
        return repository;
    }

    public void setRepository(UsuarioRepository repository) {
        this.repository = repository;
    }
}
