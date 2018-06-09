package persistencia.servicios.Service;

import modelo.Usuario;
import persistencia.repositorios.UsuarioRepository;
import persistencia.servicios.Service.GenericService;

public class UsuarioService extends GenericService<Usuario> {

    private UsuarioRepository repository;



    @Override
    public UsuarioRepository getRepository() {
        return repository;
    }

    public void setRepository(UsuarioRepository repository) {
        this.repository = repository;
    }
}
