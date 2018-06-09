package persistencia.repositorios;

import modelo.Cliente;
import org.hibernate.Criteria;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository
        extends HibernateGenericDAO<Cliente>
        implements GenericRepository<Cliente> {
    @Override
    protected Class<Cliente> getDomainClass() {
        return Cliente.class;
    }


    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Cliente getClienteByPhone(final String pattern) {

        return (Cliente) this.getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public Cliente doInHibernate(final Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(Cliente.class);
                criteria.add(Restrictions.like("telefono", "%" + pattern + "%"));
                return (Cliente)criteria.uniqueResult();
            }

        });
    }
}
