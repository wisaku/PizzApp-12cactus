package persistencia.repositorios;

import modelo.Cliente;
import modelo.Pedido;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoRepository
        extends HibernateGenericDAO<Pedido>
        implements GenericRepository<Pedido> {

    @Override
    protected Class<Pedido> getDomainClass() {
        return Pedido.class;
    }


    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Pedido getPedidoPorIDCliente(final String pattern) {

        return (Pedido) this.getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public Pedido doInHibernate(final Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(Cliente.class);
                criteria.add(Restrictions.like("nroPedido", "%" + pattern + "%"));
                return (Pedido)criteria.uniqueResult();
            }

        });
    }
}
