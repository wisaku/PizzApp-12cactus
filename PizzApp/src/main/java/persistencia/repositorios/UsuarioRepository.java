package persistencia.repositorios;

import modelo.Usuario;

public class UsuarioRepository
        extends HibernateGenericDAO<Usuario>
        implements GenericRepository<Usuario> {


    @Override
    protected Class<Usuario> getDomainClass() {
        return Usuario.class;
    }

}
